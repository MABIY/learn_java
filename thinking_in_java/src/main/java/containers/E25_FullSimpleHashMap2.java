package containers;

import net.lh.util.Countries;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Instead of using a LIstIterator for each bucket,
 * modify MapEntry so it is a self-contained
 * singly-linked list (each MapEnty should have a
 * forward link to the next MapEntry). Modify the
 * rest of the code in SimpleHashMap.java so
 * this new approach works correctly
 **/
class SimpleHashMap5<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    Entry<K, V>[] buckets = new Entry[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        Entry<K, V> newPair = new Entry<>(key, value);
        if (buckets[index] == null) {
            buckets[index] = newPair;
        }
        Entry<K, V> prevPair = null; // Previous element
        boolean found = false;
        for (Entry<K, V> pair = buckets[index]; pair != null; pair = pair.next) {
            if (pair.getKey().equals(key)) {
                oldValue = pair.getValue();
                // Replace old with new
                if (prevPair != null) {
                    prevPair.next = newPair;
                } else {
                    buckets[index] = newPair;
                }
                newPair.next = pair.next;
                found = true;
                break;
            }
            prevPair = pair;
        }
        if (!found) {
            prevPair.next = newPair; //lhtd prevPair　is null
        }
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        for (Entry<K, V> pair = buckets[index]; pair != null; pair = pair.next) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }


    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (Entry<K, V> bucket : buckets) {
            for (Entry<K, V> pair = bucket; pair != null; pair = pair.next) {
                set.add(pair);
            }
        }
        return set;
    }


    public void clear() {
        // Effectively erase everything by allocating
        // a new empty array of buckets:
        buckets = new Entry[SIZE];
    }

    public V remove(Object key) {
        // Code is copied from get(), except that
        // before returning the value, the Map.Entry is
        // removed from the "list":
        int index = Math.abs(key.hashCode()) % SIZE;
        Entry<K, V> prePair = null; // Previous element
        for (Entry<K, V> pair = buckets[index]; pair != null; pair = pair.next) {
            if (pair.getKey().equals(key)) {
                V value = pair.getValue();
                if (prePair != null) {
                    prePair.next = pair.next;
                } else {
                    buckets[index] = null;
                }
                return value;
            }
        }
        return null;
    }

    public int size() {
        // Could rely on the inherited implementation, which
        // returns entrySet().size(), but this is faster:
        int sz = 0;
        for (Entry<K, V> bucket : buckets) {
            for (Entry<K, V> pair = bucket; pair != null; pair = pair.next) {
                sz++;
            }
        }
        return sz;
    }

    public boolean isEmpty() {
        // Could just say return size() == 0
        // but this is faster:
        for (Entry<K, V> bucket : buckets) {
            if (bucket != null) {
                return false;
            }
        }
        return true;
    }

    public boolean containsKey(Object key) {
        // A slight modification of the previous method:
        for (Entry<K, V> bucket : buckets) {
            for (Entry<K, V> pair = bucket; pair != null; pair = pair.next) {
                if (pair.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Entry<K, V> implements Map.Entry<K, V> {
        Entry<K, V> next;
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V result = value;
            this.value = value;
            return result;
        }

        public int hashCode() {
            return key.hashCode() ^ (value == null ? 0 : value.hashCode());
        }

        public boolean equals(Object o) {
            if (o instanceof Entry) {
                @SuppressWarnings("unchecked")
                Entry<K, V> e = (Entry<K, V>) o;
                Object key1 = getKey();
                Object key2 = e.getKey();
                if (key1.equals(key2)) {
                    Object val1 = getValue();
                    Object val2 = e.getValue();
                    return val1 == null ? val2 == null : val1.equals(val2);
                }
            }
            return false;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}


public class E25_FullSimpleHashMap2 {
    public static void main(String[] args) {
        SimpleHashMap5<String, String>
                m = new SimpleHashMap5<>(),
                m2 = new SimpleHashMap5<>();
        m.putAll(Countries.capitals(10));
        m2.putAll(Countries.capitals(10));
        print("m.size() = " + m.size());
        print("m.isEmpty() = " + m.isEmpty());
        print("m.equal(m2) = " + m.equals(m2));
        print("m.containsKey(\"BENIN\") = " + m.containsKey("BENIN"));
        print("m.containsKye(\"MARS\") = " + m.containsKey("MARS"));
        print("m.keySet() = " + m.keySet());
        print("m.values() = " + m.values());
        m.remove("ALGERIA");
        print("m = " + m);
    }
}
