package concurrency;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import static net.mindview.util.Print.print;

/**
 * @author lh
 */
public class Test {
    enum Status{
        READY,
        OK,
    }

    public Status status = Status.READY;

    public static void main(String[] args) {
        BlockingQueue<Test> queu1 = new LinkedBlockingQueue<>(), queue2
                = new LinkedBlockingQueue<>(), finish = new LinkedBlockingQueue<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new task1(queu1));
        exec.execute(new task1(queu1));
        exec.execute(new task1(queu1));
        exec.execute(new task1(queu1));
        exec.execute(new task1(queu1));
        exec.execute(new task1(queu1));
        exec.execute(new task1(queu1));
        exec.execute(new task2(queu1,finish));
        exec.execute(new task2(queu1,finish));
        exec.execute(new task2(queu1,finish));
        exec.execute(new task2(queu1,finish));
        exec.execute(new task2(queu1,finish));
        exec.execute(new task2(queu1,finish));
        exec.execute(new task2(queu1,finish));
        exec.execute(new Task3(finish));
    }

    @Override
    public String toString() {
        return "Status :" + status.name();
    }
}

class task1 implements Runnable {
    BlockingQueue<Test> tests;

    public task1(BlockingQueue<Test> tests) {
        this.tests = tests;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                tests.put(new Test());
            } catch (InterruptedException e) {
                print("task1 interrupted");
            }
        }
        print("task1 end");
    }
}

class task2 implements Runnable {
    BlockingQueue<Test> tests;
    BlockingQueue<Test> finish;

    public task2(BlockingQueue<Test> tests,BlockingQueue<Test> finish) {
        this.tests = tests;
        this.finish = finish;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Test t =tests.take();
                t.status = Test.Status.READY;
                finish.put(t);
            } catch (InterruptedException e) {
                print("task1 interrupted");
            }
        }
        print("task1 end");
    }
}

class Task3 implements Runnable {
    BlockingQueue<Test> finish;

    public Task3(BlockingQueue<Test> finish) {
        this.finish = finish;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Test t = finish.take();
                if (t.status != Test.Status.READY) {
                    throw new RuntimeException(t.toString());
                } else {
                    System.out.println("finish" + t);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}