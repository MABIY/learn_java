package concurrency;

import javax.security.auth.login.CredentialException;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author lh
 * Modify Exercise 5 following the example of the
 * ThreadMethod class, so that runTask() takes an
 * argument of the number of Fibonacci numbers to sum,
 * and each time you call runTask() it returns
 * the Future produced by the  call to submit().
 */
class FibonacciSum2{
    private static ExecutorService exec;

    private static int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public static synchronized Future<Integer> runTask(final int n) {
        assert exec != null;
        return exec.submit(new Callable<Integer>() {
            int sum = 0;

            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < n; i++) {
                    sum += fib(i);
                }
                return sum;
            }
        });
    }

    public static synchronized void init() {
        if (exec == null) {
            exec = Executors.newCachedThreadPool();
        }
    }
    public static synchronized void shutdown() {
        if (exec != null) {
            exec.shutdown();
        }
        exec = null;
    }
}
public class E10_FibonacciSum2 {
    public static void main(String[] args) {
        ArrayList<Future<Integer>> results = new ArrayList<>();
        FibonacciSum2.init();
        for (int i = 0; i < 5; i++) {
            results.add(FibonacciSum2.runTask(i));
        }
        Thread.yield();
        FibonacciSum2.shutdown();
        for (Future<Integer> result : results) {
            try {
                System.out.println(result.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
