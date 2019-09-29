package concurrency;

import com.sun.org.apache.xalan.internal.xsltc.runtime.InternalRuntimeError;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * General idiom for interrupting a task
 */

class NeedsCleanup{
    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
        print("NeedsCleanup " + id);
    }
    public void cleanup() {
        print("Cleaning up " + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Point1
                NeedsCleanup n1 = new NeedsCleanup(1);
                // Start try-finally immediately after definition
                // of n1. to guarantee proper cleanup of n1:
                try {
                    print("Sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    // point2
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    // Guarantee proper cleanup of n2
                    try {
                        print("Calculating");
                        // A time-consuming, non-blocking operation:
                        for (int i = 0; i < 2500000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        print("Finished time-consuming operation");
                    }finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
        } catch (InterruptedException e) {
            print("Exiting via InterruptedException");
        }
    }
}
public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        args = new String[]{"1100"};
        if (args.length != 1) {
            print("usage: java InterruptingIdiom delay-in-mS");
            System.exit(1);
        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        t.interrupt();
    }
}
