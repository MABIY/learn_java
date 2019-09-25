package concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lh
 * Locks in the concurrent library allow you
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed() {
        boolean captured = lock.tryLock();
        //lhnw
    }
}
