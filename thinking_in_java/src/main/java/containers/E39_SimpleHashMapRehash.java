package containers;

import net.lh.util.Countries;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author lh
 * Invoke a private rehash() method in SimpleHashMap when the load
 * factor exceeds 0.75. During rehash, determine
 * the new number o buckets by finding the first prime
 * number greater than twice the original number of buckets.
 **/
class SimpleHashMap7<K,V> extends SimpleHashMap<K,V>{
    private int count; // Number of elements
    private static final double loadFactor = 0.75;
    // Use a prime initial capacity; the JDK uses a number,
    // which is a power of 2:
    private final static int initialCapacity = 11;

    private int capacity = initialCapacity;
    private int threshold = (int) (capacity * loadFactor);
    {
        buckets = new LinkedList[capacity];
    }

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode() % capacity);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }
        if (!found) {
            if (count >= threshold) {
                rehash();
            }
            if (buckets[index] == null) {
                buckets[index] = new LinkedList<>();
            }
            buckets[index].add(pair);
            ++count;
        }
        return oldValue;
    }

    private boolean isPrime(int candidate) {
        for (int i = 2; i <= candidate/2; i++) {
            if (candidate % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int nexPrime(int candidate) {
        while (!isPrime(candidate)) {
            candidate++;
        }
        return candidate;
    }

    private void rehash() {
        // Points to a new Set of entries, so it
        // Won't be bothered by what we're about to do:
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        capacity = nexPrime(capacity * 2);
        System.out.println("Rehasing, new capacity = " + capacity);
        buckets = new LinkedList[capacity];
        threshold = (int) (capacity * loadFactor);
        count = 0;
    // Fill new buckets (crude ,but it works)
        while (it.hasNext()) {
            Map.Entry<K, V> me = it.next();
            put(me.getKey(), me.getValue());
        }
    }
}

public class E39_SimpleHashMapRehash {
    public static void main(String[] args) {
        SimpleHashMap7<String, String> m = new SimpleHashMap7<>();
        m.putAll(Countries.capitals(50));
        System.out.println(m);
    }
}
