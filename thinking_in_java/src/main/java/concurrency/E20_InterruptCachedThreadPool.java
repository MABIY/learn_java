package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lh
 * Modify CachedThreadPool.java so that all tasks receive
 * an interrupt() before they are completed.
 */
class LiftOff2 implements Runnable {
    protected int countDonw = 5000;
    private static int taskCount;
    private final int id = taskCount++;

    public LiftOff2() {
    }

    public LiftOff2(int countDonw) {
        this.countDonw = countDonw;
    }
    public String status() {
        return "#" + id + "(" + (countDonw > 0 ? countDonw : "Liftoff!") + "),";
    }

    @Override
    public void run() {
        while (countDonw-- > 0) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted # " +id);
                return;
            }
            System.out.println(status());
            Thread.yield();
        }
    }
}
public class E20_InterruptCachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff2());
        }
        Thread.yield();
        exec.shutdownNow();
    }
}
