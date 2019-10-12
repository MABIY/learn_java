package concurrency;

import net.lh.util.CountingGenerator;
import net.lh.util.Generator;
import net.lh.util.MapData;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * {Args: 1 10 10} (Fast verification )
 * ****************************************
 * Following the example of ReaderWriterList.java, create
 * a ReaderWriterMap using a HashMap. Invvestigate its
 * performance by modifying mapComparisons.java. How does
 * it compare to a synchronized HashMap and a
 * ConcurrentHashMap?
 * ****************************************
 */

class ReaderWriterMap<K,V> extends AbstractMap<K,V>{
    private HashMap<K, V> lockedMap;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    public ReaderWriterMap(Generator<K> genK, int size, V initialValue) {
        lockedMap = new HashMap<>(MapData.map(genK, initialValue, size));
    }

    public V put(K key, V value) {
        Lock wlock = lock.writeLock();
        wlock.lock();
        try {
            return lockedMap.put(key, value);
        }finally {
            wlock.unlock();
        }
    }
    public V get(Object key) {
        Lock rlock = lock.readLock();
        rlock.lock();
        try {
            // Comment out if you would like to trace how many
            // readers are acquiring the lock simultaneously:
            if (lock.getReadLockCount() > 1) {
                print(lock.getReadLockCount());
            }
            return lockedMap.get(key);
        }finally {
            rlock.unlock();
        }
    }
    // Dummy implementation
    public Set<Map.Entry<K,V>> entrySet() {
        return null;
    }
}

class ReaderWriterMapTest extends MapTest{
    public ReaderWriterMapTest(int nReaders, int nWriters) {
        super("ReaderWriterMap", nReaders, nWriters);
    }

    @Override
    Map<Integer, Integer> containerInitializer() {
        return new ReaderWriterMap<Integer, Integer>(
                new CountingGenerator.Integer(), containerSize, 1
        );
    }
}
public class E40_MapComparisons2 {
    public static void main(String[] args) {
        Tester.initMain(args);
        new SynchronizedHashMapTest(10, 0);
        new SynchronizedHashMapTest(9, 1);
        new SynchronizedHashMapTest(5, 5);
        new ConcurrentHashMapTest(10, 0);
        new ConcurrentHashMapTest(9, 1);
        new ConcurrentHashMapTest(5, 5);
        new ReaderWriterMapTest(10, 0);
        new ReaderWriterMapTest(9, 1);
        new ReaderWriterMapTest(5, 5);
        Thread.yield();
        Tester.exec.shutdown();
    }
}
