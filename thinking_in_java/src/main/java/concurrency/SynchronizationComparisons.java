package concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lh
 * Comparing the performance of explicit locks
 */
abstract class Accumulator{
    public static long cycles = 50000L;
    // Number of Modifiers and Readers during each test:
    private static final int N = 4;
    private static ExecutorService exec = Executors.newFixedThreadPool(N * 2);
    private static CyclicBarrier barrier = new CyclicBarrier(N * 2 + 1);
    protected volatile int index = 0;
    protected volatile long value = 0;
    protected long duration = 0;
    protected String id = "error";
    protected final static int SIZE = 100000;
    protected static int[] preLoaded = new int[SIZE];
}
public class SynchronizationComparisons {
    //todo
}
