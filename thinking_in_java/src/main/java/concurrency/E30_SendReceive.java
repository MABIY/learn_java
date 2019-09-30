package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Modify PipedIO.java to use a BlockingQueue instead of
 * a pipe
 */

class CharQueue extends LinkedBlockingQueue<Character>{}

class Sender30 implements Runnable {
    private Random rand = new Random(47);
    private CharQueue out = new CharQueue();

    public CharQueue getQueue() {
        return out;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (char c = 'A'; c <= 'z'; c++) {
                    out.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (InterruptedException e) {
            print(e + " Sender interrupted");
        }
    }
}

class Receiver30 implements Runnable{
    private CharQueue in;

    public Receiver30(CharQueue in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Blocks until characters are there:
                print("Read: " + in.take() +", ");
            }
        } catch (InterruptedException e) {
            print(e + " Reader interrupted");
        }
    }
}

public class E30_SendReceive {
    public static void main(String[] args) throws InterruptedException {
        Sender30 sender30 = new Sender30();
        Receiver30 receiver30 = new Receiver30(sender30.getQueue());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender30);
        exec.execute(receiver30);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}
