package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lh
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        // Constructor argument is number of threads:
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
