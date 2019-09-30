package concurrency.waomatic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lh
 * Solve a single-producer, single-consumer problem using
 * wait() and notifyAll(). The producer must not overflow
 * the receiver's buffer, which can happen if the producer
 * is faster than the consumer. if hte consumer is faster
 * then the producer, then it must not read the same data
 * more than once. Do not accume anything about the relative
 * speeds of the producer or consumer
 */
// A queue for solving flow-control problems
class FlowQueue<T>{
    private Queue<T> queue = new LinkedList<>();
    private int maxSize;

    public FlowQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void put(T v) throws InterruptedException {
        while (queue.size() >= maxSize) {
            wait();
        }
        queue.offer(v);
        maxSize++;
        notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T returnVal = queue.poll();
        maxSize--;
        notifyAll();
        return returnVal;
    }
}

class Item{
    private static int counter;
    private int id = counter++;

    @Override
    public String toString() {
        return "Item " + id;
    }
}

// Produces Item objects
class Producer implements Runnable {
    private int delay;
    private FlowQueue<Item> output;

    public Producer(int sleepTime, FlowQueue<Item> output) {
        this.delay = sleepTime;
        this.output = output;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                output.put(new Item());
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

// Consumes any object
class Consumer implements Runnable {
    private int delay;
    private FlowQueue<?> input;

    public Consumer(int sleepTime, FlowQueue<?> input) {
        this.delay = sleepTime;
        this.input = input;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                System.out.println(input.get());
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
public class E24_ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        args = new String[]{"1", "200"};
        if (args.length < 2) {
            System.err.println("Usage java E24_ProducerConsumer" +
                    " < producer sleep time < consumer sleep time>");
        }
        int producerSleep = Integer.parseInt(args[0]);
        int consumerSleep = Integer.parseInt(args[1]);
        FlowQueue<Item> fq = new FlowQueue<Item>(100);
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.execute(new Producer(producerSleep, fq));
        exec.execute(new Consumer(consumerSleep, fq));
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}
