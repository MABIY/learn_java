package concurrency;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lh
 */
public class AtomicIntegerTest implements Runnable {
    public Set<Integer> integers = new HashSet<>();
    private AtomicInteger i = new AtomicInteger();

    public static void main(String[] args) {
        // new Timer().schedule(new TimerTask() {
        //     @Override
        //     public void run() {
        //         System.out.println("Aborting");
        //         System.exit(0);
        //     }
        // }, 5000); //Terminate after 5 seconds
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        exec.execute(ait);
        exec.execute(ait);
        exec.execute(ait);
        while (true) {
            int val = ait.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }

    public int getValue() {
        return i.get();
    }

    private void evenIncrement() {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(5));
        } catch (InterruptedException e) {
        }
        if (!integers.add(i.addAndGet(2))) {
            throw new RuntimeException("异常");
        }
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }
}
