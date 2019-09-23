package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lh
 * Calling sleep() to pause for a while
 */
public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.println(status());
                // Old-style:
                // Thread.sleep(100);
                // Java SE5/6-style:
                TimeUnit.MICROSECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
