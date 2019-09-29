package concurrency.waomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lh
 * Create an example of a busy wait. One task sleeps for a
 * while and then sets a flag to true, the second task
 * watches that flat inside a while loop (this is the busy wait)
 * and when the flag becomes true, sets it back to false and reports
 * the change to the console. Note how much wasted time the program
 * spends inside the busy wait,and create a second version fo the
 */
public class E22_BusyWait {
    private static volatile boolean flag;
    private static int spins;

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        return;
                    }
                    flag = true;
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    // The busy-wait loop
                    while (!flag && !Thread.currentThread().isInterrupted()) {
                        spins++;
                    }
                    System.out.println("Spun " + spins + " times");
                    spins = 0;
                    flag = false;
                    if (Thread.interrupted()) {
                        return;
                    }
                }
            }
        };
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(r1);
        exec.execute(r2);
        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
    }
}
