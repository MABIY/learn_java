package containers;

import java.util.*;

import static net.mindview.util.Print.print;
import static org.eclipse.swt.internal.gtk.OS.map;
import static org.eclipse.swt.internal.gtk.OS.pango_attr_iterator_range;

/**
 * @author lh
 * Apply the tests in Maps.java to SlowMap to
 * verify that is works.Fix anything in Slowmap
 * that doesn't workd correctly.
 **/
class SlowMap2<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    private EntrySet entrySet = new EntrySet();

    @Override
    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException();
        }
        V oldValue = get(key); // The old value or null
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            throw new NullPointerException();
        }
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }

    // Uses the 'Flyweight' pattern
    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                boolean canRemove;
                private int index = -1;

                @Override
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }

                @Override
                public Entry<K, V> next() {
                    canRemove = true;
                    ++index;
                    return new MapEntry<>(keys.get(index), values.get(index));
                }

                @Override
                public void remove() {
                    if (!canRemove) {
                        throw new IllegalStateException();
                    }
                    canRemove = false;
                    keys.remove(index);
                    values.remove(index--);
                }
            };
        }

        @Override
        public boolean contains(Object o) {
            if (o instanceof MapEntry) {
                MapEntry<K, V> e = (MapEntry<K, V>) o;
                K key = e.getKey();
                if (keys.contains(key)) {
                    return e.equals(new MapEntry<>(key, get(key)));
                }
            }
            return false;
        }

        @Override
        public boolean remove(Object o) {
            if (contains(o)) {
                MapEntry<K, V> e = (MapEntry<K, V>) o;
                K key = e.getKey();
                V val = e.getValue();
                keys.remove(key);
                values.remove(val);
                return true;
            }
            return false;
        }

        @Override
        public int size() {
            return keys.size();
        }

        @Override
        public void clear() {
            keys.clear();
            values.clear();
        }
    }
}

public class E16_SlowMapTest {
    public static void printKeys(Map<Integer, String> map) {
        print("Size = " + map.size() + ", ");
        print("Keys: ");
        print(map.keySet()); // Produce a Set of the keys
    }

    public static void test(Map<Integer, String> map) {
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        // Map has 'Set' behavior for  keys:
        map.putAll(new CountingMapData(25));
        printKeys(map);
        // Producing a Collection of the values:
        print("Vlaues: ");
        print(map.values());
        print(map);
        print("map.containsKeys(11): " + map.containsKey(11));
        print("map.get(11): " + map.get(11));
        print("map.containsValue(\"F0\"): " +
                map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        print("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        print("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        // Operations on the Set change the map:
        map.keySet().removeAll(map.keySet());
        print("map.isEmpty(): " + map.isEmpty());
    }

    public static void main(String[] args) {
        System.out.println("Testing SlowMap2");
        test(new SlowMap2<>());
        System.out.println("Testing SlowMap");
        test(new SlowMap<>());
    }
}
