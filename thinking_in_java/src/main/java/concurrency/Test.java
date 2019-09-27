package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lh
 */
public class Test {
    public static synchronized void test() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        singleThread.execute(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Runnable() {
            @Override
            public void run() {
                test();
            }
        });
        TimeUnit.MILLISECONDS.sleep(100);
        exec.shutdownNow();
        System.out.println("interrupt success");

    }
}
