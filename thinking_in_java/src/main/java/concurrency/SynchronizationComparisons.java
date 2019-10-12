package concurrency;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printf;

/**
 * @author lh
 * Comparing the performance of explicit locks
 */
abstract class Accumulator {
    protected final static int SIZE = 100000;
    // Number of Modifiers and Readers during each test:
    private static final int N = 4;
    public static long cycles = 50000L;
    protected static int[] preLoaded = new int[SIZE];
    public static ExecutorService exec = Executors.newFixedThreadPool(N * 2);
    private static CyclicBarrier barrier = new CyclicBarrier(N * 2 + 1);

    static {
        // Load the array of random numbers
        Random rand = new Random(47);
        for (int i = 0; i < SIZE; i++) {
            preLoaded[i] = rand.nextInt();
        }
    }

    protected volatile int index = 0;
    protected volatile long value = 0;
    protected long duration = 0;
    protected String id = "error";

    public static void report(Accumulator acc1, Accumulator acc2) {
        System.out.printf("%-22s: %.2f\n", acc1.id + "/ " + acc2.id, (double) acc1.duration / (double) acc2.duration);
    }

    public abstract void accumulate();

    public abstract long read();

    public void timedTest() {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            exec.execute(new Modifier());
            exec.execute(new Reader());
        }
        try {
            barrier.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        duration = System.nanoTime() - start;
    }

    private class Modifier implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < cycles; i++) {
                accumulate();
            }
            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class Reader implements Runnable {
        protected volatile long value;

        @Override
        public void run() {
            for (int i = 0; i < cycles; i++) {
                value = read();
            }
            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class BaseLine extends Accumulator {
    {
        id = "BaseLine";
    }

    @Override
    public void accumulate() {
        synchronized (this) {
            value += preLoaded[index++];
            if (index >= SIZE) {
                index = 0;
            }
        }
    }

    @Override
    public synchronized long read() {
        return value;
    }
}

class LockTest extends Accumulator {
    {
        id = "Lock";}

    private Lock lock = new ReentrantLock();
    @Override
    public void accumulate() {
        lock.lock();
        try {
            value += preLoaded[index++];
            if(index>=SIZE ) index = 0;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public long read() {
        lock.lock();
        try {
            return value;
        }finally {
            lock.unlock();
        }
    }
}

class SynchronizedTest extends Accumulator {
    {id = "synchronized";}
    @Override
    public synchronized void accumulate() {
        value += preLoaded[index++];
        if (index >= SIZE) {
            index = 0;
        }
    }

    @Override
    public synchronized long read() {
        return value;
    }
}

class AtomicTest extends Accumulator {
    {id = "Atomice";}

    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0);

    @Override
    public void accumulate() {
        // Oops! Relying on more than one Atomic at
        // a time doesn't work. But it still given us
        // a performance indicator
        synchronized (index) {

            int i = index.getAndIncrement();
            if (i >= SIZE) {
                index.set(0);
            }
            value.getAndAdd(preLoaded[i]);
            if (++i >= SIZE) {
                index.set(0);
            }
        }
    }

    @Override
    public long read() {
        return value.get();
    }
}
public class SynchronizationComparisons {
    static BaseLine baseLine = new BaseLine();
    static SynchronizedTest synch = new SynchronizedTest();
    static LockTest lock = new LockTest();
    static AtomicTest atomic = new AtomicTest();
    static void test() {
        print("==============================");
        printf("%-12s : %13d\n", "Cycles", Accumulator.cycles);
        baseLine.timedTest();
        synch.timedTest();
        lock.timedTest();
        atomic.timedTest();
        Accumulator.report(synch, baseLine);
        Accumulator.report(lock,baseLine);
        Accumulator.report(atomic,baseLine);
        Accumulator.report(synch, lock);
        Accumulator.report(synch,atomic);
        Accumulator.report(lock, atomic);
    }

    public static void main(String[] args) throws InterruptedException {
        int iterations = 5; // Default
        if (args.length > 0) { //Optionally change iterations
            iterations = new Integer(args[0]);
        }
        // the first time fill the thread pool:
        print("Warmup");
        baseLine.timedTest();
        // Now the initial test doesn't include the cost
        // of starting the threads for the first time.
        // Produce multiple data points:
        for (int i = 0; i < iterations; i++) {
            test();
            Accumulator.cycles *= 2;
        }
        Accumulator.exec.shutdown();
    }
}
