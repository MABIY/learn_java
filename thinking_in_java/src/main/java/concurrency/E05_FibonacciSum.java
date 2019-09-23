package concurrency;

import net.lh.util.Generator;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author lh
 * Modify Exercise 2 so that the task is a Callable
 * that sums the values of all the Fibonacci numbers
 * Create several tasks and display the results
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

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }
}

public class E05_FibonacciSum {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            results.add(exec.submit(new FibonacciSum(i)));
        }
        for (Future<Integer> result : results) {
            try {
                System.out.println(result.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
