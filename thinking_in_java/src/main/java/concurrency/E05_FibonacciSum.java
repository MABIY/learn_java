package concurrency;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by LiuHua on 18-3-26.
 */
class FibonacciSum implements Generator<Integer>, Callable<Integer> {
    private final int n;
    private int count;

    public FibonacciSum(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += next();
        }
        return sum;
    }

    private Integer fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    @Override
    public Integer next() {
        return fib(count++);
    }
}

public class E05_FibonacciSum {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            results.add(exec.submit(new FibonacciSum(i)));
        }
        Thread.yield();
        exec.shutdown();
        for (Future<Integer> fi : results) {
            try {
                System.out.println(fi.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
