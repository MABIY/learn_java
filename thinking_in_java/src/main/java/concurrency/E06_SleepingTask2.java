package concurrency;

import sun.font.FontRunIterator;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lh
 * {Args:5}
 * ***********************Exercise 6 ***************************
 * Create a task that sleeps for a random amount
 * of time between 1 and 10 seconds, then displays
 * **************************************************
 */
class SleepingTask2 implements Runnable{
    private static Random rnd = new Random();
    private final int sleep_time = rnd.nextInt(10) + 1;
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(sleep_time);
        } catch (InterruptedException e) {
            System.out.println("INterrupted: " + e);
        }
        System.out.println(sleep_time);
    }
}
public class E06_SleepingTask2 {
    public static void main(String[] args) {
        args = new String[]{"5"};
        ExecutorService exec = Executors.newCachedThreadPool();
        if (args.length != 1) {
            System.out.println("Provide the quantity of tasks to run");
            return;
        }
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            exec.execute(new SleepingTask2());
        }
        Thread.yield();
        exec.shutdown();
    }
}
