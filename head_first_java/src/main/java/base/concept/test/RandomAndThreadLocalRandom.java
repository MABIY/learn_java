package base.concept.test;

import java.util.Random;
import java.util.concurrent.*;

public class RandomAndThreadLocalRandom {
    private static CyclicBarrier barrier;
    private static CyclicBarrier barrier1;
    private static ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
    private static Random rand = new Random();
    private static long ThreadLocalStart;
    private static long RandomStart;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec1 = Executors.newCachedThreadPool();
        int loopCount = 3000;
        barrier = new CyclicBarrier(loopCount);
        barrier1 = new CyclicBarrier(loopCount);

        for (int i = 0; i < loopCount; i++) {
            exec.execute(new ThreadLocalGenerator());
        }
        for (int i = 0; i < loopCount; i++) {
            exec1.execute(new RandomGenerator());
        }
        TimeUnit.SECONDS.sleep(10);
    }

    private static class ThreadLocalGenerator implements Runnable {
        @Override
        public void run() {
            threadLocalRandom.nextInt();
            try {
                if (0 == barrier.await()) {
                    System.out.println(" Local cost time:" + (System.nanoTime() - ThreadLocalStart));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    private static class RandomGenerator implements Runnable {
        @Override
        public void run() {
            rand.nextInt();
            try {
                if (0 == barrier.await()) {
                    System.out.println("random cost time:" + (System.nanoTime() - RandomStart));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    private class countTime implements Runnable {
        @Override
        public void run() {
            long start = System.nanoTime();

        }
    }


}
