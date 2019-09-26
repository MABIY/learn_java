package concurrency;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lh
 * Lock in the current library allow you
 * to given up on trying to acuqire a lock
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        }finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2,TimeUnit.Seconds): " + captured);
        }finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // True -- lock is available
        al.timed(); // True -- lock is available
        // Now craete a separate task to grab the lock
        new Thread(){
            {
                setDaemon(true);}

            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        TimeUnit.MILLISECONDS.sleep(10); // Give the 2nd task a chance
        al.untimed(); // False --lock grabbed by task
        al.timed(); // False -- lock grabbed by task
    }
}
