package concurrency;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.*;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Interrupting a blocked thread
 */
class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            print("InterruptedException");
        }
        print("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            print("Waiting for read()");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                print("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        print("Exiting IOBlocked.run()");
    }
}

class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true) { // Never releases lock
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread(){
            @Override
            public void run() {
                f(); // Lock acquired by this
            }
        }.start();
    }

    @Override
    public void run() {
        print("Trying to call f()");
        f();
        print("Exiting SysnchronizedBlocked.run()");
    }
}
public class Interrupting {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        print("Interrupting " + r.getClass().getName());
        f.cancel(true); // Interrupts if running
        print("Interrupt sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        print("Aborting with System.exit(0)");
        System.exit(0); // .. since last 2 interrupts failed
    }
}
