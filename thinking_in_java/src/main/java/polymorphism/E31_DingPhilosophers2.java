package polymorphism;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Change DeadlockingDingPhilosophers.java so that wehn a
 * philosopher is done with their chopsticsk,they drop them
 * into a bin, wehn a philosopher wants to eat, they take
 * the next two available chopsticsk from the bin, does this
 * eliminate the posibilitry of deallock? can you
 * reintroduce deadlock by simpley reducing the number of
 * available chopsticks?
 **/

class Chopstick31{
    private final int id;
    private boolean taken;

    public Chopstick31(int id) {
        this.id = id;
    }
    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Chopstick " + id;
    }
}


class ChopstickQueue31 extends LinkedBlockingQueue<Chopstick31>{}
class ChopstickBin31 {
    private ChopstickQueue31 bin = new ChopstickQueue31();
    public Chopstick31 get() throws InterruptedException {
        return bin.take();
    }

    public void put(Chopstick31 chopstick31) throws InterruptedException {
        bin.put(chopstick31 );
    }
}

class Philosopher31 implements Runnable {
    private static Random rand = new Random(47);
    private final int id;
    private final int ponderFactor;
    private ChopstickBin31 bin;
    private void pause() throws InterruptedException {
        if (ponderFactor == 0) {
            return;
        }
        TimeUnit.MICROSECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }

    public Philosopher31(int id, int ponderFactor, ChopstickBin31 bin) {
        this.id = id;
        this.ponderFactor = ponderFactor;
        this.bin = bin;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                print(this + " " + "thinking");
                pause();
                // get one chopstick from the bin
                Chopstick31 c1 = bin.get();
                print(this + " has " + c1 + " waiting for another one");
                // Get another chopstick from bin
                Chopstick31 c2 = bin.get();
                print(this + " has " + c2);
                print(this + " eating");
                pause();
                // Put the chopstick back in bin
                bin.put(c1);
                bin.put(c2);
            }
        } catch (InterruptedException e) {
            print(this + " " + "exiting via interrupt");
        }
    }

    @Override
    public String toString() {
        return "Philosophter " + id;
    }
}
public class E31_DingPhilosophers2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        args = new String[]{"5", "0", "deallock", "5"};
        if (args.length < 3) {
            System.out.println("usage:\n" +
                    "java E31_DIngPhilosophers32 " +
                    "numberOfPhilosophers ponderFactor deadlock " +
                    "timeout\n" + "A nonzero ponderFactor will " +
                    "generate a random sleep tiem during think().\n" +
                    "if dealock is not the string " +
                    "'deallock ', the program will not deadlock.\n" +
                    "A nonzero timeout will stop the program after " +
                    "that number of seconds.");
            System.exit(1);
        }
        ChopstickBin31 bin = new ChopstickBin31();
        int size = Integer.parseInt(args[0]);
        int ponder = Integer.parseInt(args[1]);
        for (int i = 0; i < size; i++) {
            bin.put(new Chopstick31(i));
        }
        // One additional chopstick guarantees that at least
        // one philosopher can eat without blocking
        if (!args[2].equals("deallock")) {
            bin.put(new Chopstick31(size));
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher31( i, ponder,bin));
        }
        if (args.length == 4) {
            TimeUnit.SECONDS.sleep(Integer.parseInt(args[3]));
        } else {
            print("Press 'ENTER' to quit");
            System.in.read();
        }
        exec.shutdownNow();


    }
}
