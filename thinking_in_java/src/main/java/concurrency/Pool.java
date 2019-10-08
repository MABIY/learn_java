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
        //todo write next
    }
}
