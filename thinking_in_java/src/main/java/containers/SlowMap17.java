package containers;

import net.lh.util.Countries;

import java.util.*;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * My solution to one of the exercise in
 * Thinking in Java 4th Edition (by Bruece Eckel);
 * it compiles and runs correc tly using jdk 1.6.0
 **/
public class SlowMap17<K, V> implements Map<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    private EntrySet entries = new EntrySet();
    private Set<K> keySet = new KeySet();

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }
    private class KeySet extends AbstractSet<K>{
        @Override
        public Iterator<K> iterator() {
            return new Iterator<K>() {
                private int index = -1;

                @Override
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }

                @Override
                public K next() {
                    int i = ++index;
                    return keys.get(index);
                }

                @Override
                public void remove() {
                    keys.remove(index--);
                }
            };
        }

        @Override
        public int size() {
            return keys.size();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SlowMap17) {
            if (this.entrySet().equals(((SlowMap17) obj).entrySet())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.entrySet().hashCode();
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        V v = get(key);
        int i = keys.indexOf(key);
        keys.remove(i);
        return v;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> me : m.entrySet()) {
            put(me.getKey(), me.getValue());
        }
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Set<K> keySet() {
        return keySet;
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entries;
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                private int index = -1;

                @Override
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }

                @Override
                public Entry<K, V> next() {
                    int i = ++index;
                    return new MapEntry<>(keys.get(i), values.get(i));
                }

                @Override
                public void remove() {
                    keys.remove(index);
                    values.remove(index--);
                }
            };
        }

        @Override
        public int size() {
            return keys.size();
        }

    }

    @Override
    public String toString() {
        return this.entrySet().toString();
    }

    public static void main(String[] args) {
        SlowMap17<String, String> m = new SlowMap17<>();
        m.putAll(Countries.capitals(15));
        print("m: " + m);
        print("m.get(\"BURUNDI\"): "+ m.get("BURUNDI"));
        print("m.entrySet(): " + m.entrySet());
        print("m.keySet(): " + m.keySet());
        print("m.values(): " + m.values());
        print("Two different maps: ");
        SlowMap17<String,String> m2 = new SlowMap17<>();
        print("m.equals(m2): " + m.equals(m2));
        m2.putAll(Countries.capitals(15));
        print("Maps with same entires: ");
        print("m.equals(m2): "+ m.equals(m2));
        m.clear();
        print("After m.clear(), m.isEmpty(): " + m.isEmpty() + ", m= " +m);
        m2.keySet().clear();
        print("After m2.keySet().clear(), m2.isEmpty(): " + m2.isEmpty() +", m2= " +m2);
    }

}
