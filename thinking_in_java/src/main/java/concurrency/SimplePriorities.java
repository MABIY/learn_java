package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by LiuHua on 18-3-26.
 */
public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d;// no optimization
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }

    public String toString() {
        return Thread.currentThread() + ". " + countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            // An expensive,interruptable opeartion:
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI + Math.E) / i;
                if (i % 100 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }
}