package concurrency;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;


/**
 * @author lh
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MICROSECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            print("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true); // Must call before start()
            daemon.start();
        }
        print("All daemon started");
        TimeUnit.MICROSECONDS.sleep(175);
    }
}
