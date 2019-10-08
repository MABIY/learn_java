package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @author lh
 * Using a Semaphore inside a Pool, to restrict
 * the number of tasks that can use a resource
 */
public class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<>();
    private volatile boolean[] checkedout;
    private Semaphore available;

    public Pool(Class<T> classObject, int size) {
        this.size = size;
        checkedout = new boolean[size];
        available = new Semaphore(size, true);
        // Load pool with objects that can be checked out:
        for (int i = 0; i < size; i++) {
            try {
                // Assume a default constructor:
                items.add(classObject.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public T checkOut() throws InterruptedException {
        available.acquire();
        return getItem();
    }

    public void checkIn(T x) {
        if (releaseItem(x)) {
            available.release();
        }
    }
    private synchronized T getItem() {
        for (int i = 0; i < size; i++) {
            if (!checkedout[i]) {
                checkedout[i] = true;
                return items.get(i);
            }
        }
        return null; // Semaphore prevents reaching here
    }

    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        if (index == -1) {
            return false; // Not in the list
        }
        if (checkedout[index]) {
            checkedout[index] = false;
            return true;
        }
        return false; // Wasn't checked out
    }
}
