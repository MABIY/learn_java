package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import static net.lh.util.Print.print;

/**
 * @author lh
 */
class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {
    protected static List<PrioritizedTask> sequence = new ArrayList<>();
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    private Random rand = new Random(47);

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }


    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(250));
        } catch (InterruptedException e) {
            // Acceptable way to exit
        }
        print(this);
    }

    @Override
    public String toString() {
        return String.format("[%1$-3d]", priority) + " Task " + id;
    }

    @Override
    public int compareTo(PrioritizedTask o) {
        return Integer.compare(o.priority, priority);
    }

    public String summary() {
        return "(" + id + ":" + priority + ")";
    }

    public static class EndSentinel extends PrioritizedTask {
        private ExecutorService exec;

        public EndSentinel(ExecutorService e) {
            super(-1); // Loest priority in this program
            exec = e;
        }

        @Override
        public void run() {
            int count = 0;
            for (PrioritizedTask prioritizedTask : sequence) {
                print(prioritizedTask.summary());
                if (++count % 5 == 0) {
                    print();
                }
            }
            print();
            print(this + " Calling shutdonwNow()");
            exec.shutdownNow();
        }
    }
}

class PrioritizedTaskProducer implements Runnable {
    private Random rand = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec;

    public PrioritizedTaskProducer(Queue<Runnable> queue, ExecutorService exec) {
        this.queue = queue;
        this.exec = exec; // Used for EndSentinel
    }

    @Override
    public void run() {
        // Unbounded queue: never blocks
        // Fill it up fast with random with random priorities:
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(rand.nextInt(10)));
            Thread.yield();
        }
        // Trickle in  highest-priority jobs
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(10));
            }
            // Add jobs , lowest priority first:
            for (int i = 0; i < 10; i++) {
                queue.add(new PrioritizedTask(1));
            }

            // A sentienl to stop all the tasks:
            queue.add(new PrioritizedTask.EndSentinel(exec));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrioritizedTaskConsumer implements Runnable{
    private PriorityBlockingQueue<Runnable> q;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Use current thread to run the task:
                q.take().run();
            }
        } catch (InterruptedException e) {
            // Acceptable way to exit
        }
        print("Finished PrioritizedTaskConsumer");
    }
}

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        exec.execute(new PrioritizedTaskProducer(queue,exec));
        exec.execute(new PrioritizedTaskConsumer(queue));

    }
}
