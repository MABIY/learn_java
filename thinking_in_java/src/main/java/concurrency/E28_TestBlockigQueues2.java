package concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.*;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify TestBlocking Queues.java by adding a new task that
 * places LiftOff on BlockingQueue, instead of doning it
 * int main()
 */
class LiftOffRunner28 implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner28(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LiftOff lo) throws InterruptedException {
        rockets.put(lo);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run(); // Use this thread
            }
        } catch (InterruptedException e) {
            print("Waking from take()");
        }
        print("Exiting LiftOffRunner");
    }
}

class LiftOffProducer implements Runnable {
    private LiftOffRunner28 runner;

    public LiftOffProducer(LiftOffRunner28 runner) {
        this.runner = runner;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                runner.add(new LiftOff(5));
            }
        } catch (InterruptedException e) {
            print("Waking from put()");
        }
        print("Exiting LiftOffProducer");
    }
}

public class E28_TestBlockigQueues2 {
    private static void getkey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void getkey(String message) {
        print(message);
        getkey();
    }

    private static void test(String msg, BlockingQueue<LiftOff> queue) {
        ExecutorService exec = Executors.newCachedThreadPool();
        print(msg);
        LiftOffRunner28 runner = new LiftOffRunner28(queue);
        LiftOffProducer producer = new LiftOffProducer(runner);
        exec.execute(runner);
        exec.execute(producer);
        getkey("Press 'ENTER' (" + msg + ")");
        exec.shutdownNow();
        print("Finished " + msg + " test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue",new LinkedBlockingQueue<LiftOff>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue", new SynchronousQueue<LiftOff>());
    }
}
