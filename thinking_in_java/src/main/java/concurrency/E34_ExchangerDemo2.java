package concurrency;

import net.lh.util.CountingGenerator;
import net.lh.util.Generator;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author lh
 * Modify ExchangerDemo.java to use your own class instead of Fat
 */
class ExchangerProducer34<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    public ExchangerProducer34(Generator<T> generator, Exchanger<List<T>> exchanger, List<T> holder) {
        this.generator = generator;
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < E34_ExchangerDemo2.size; i++) {
                    holder.add(generator.next());
                }
                // Exchange full for empty
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
            // oK to terminate this way
        }
    }
}

class ExchangerConsumer34<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    public ExchangerConsumer34(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for (T t : holder) {
                    value = t; // Fetch out value
                    holder.remove(t); // OK ofr CopyOnWriteArrayList
                }
            }
        } catch (InterruptedException e) {
            // OK to terminate this way
        }
        System.out.println("Final value: " + value);
    }
}

public class E34_ExchangerDemo2 {
    static int size = 10;
    static int delay = 5;  // Seconds

    public static void main(String[] args) throws InterruptedException {
        if (args.length > 0) {
            size = new Integer(args[0]);
        }
        if (args.length > 1) {
            delay = new Integer(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Integer>> xc = new Exchanger<>();
        List<Integer> producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer34<Integer>(new CountingGenerator.Integer(),xc,producerList));
        exec.execute(new ExchangerConsumer34<Integer>(xc, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}
