package containers;

import util.Countries;

import java.util.*;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2019-01-15 13:34
 **/

public class SlowMap17<K,V> implements Map<K,V> {
	private List<K> keys = new ArrayList<>();
	private List<V> values = new ArrayList<>();
	private EntrySet entries = new EntrySet();
	private Set<K> keysSet = new KeySet();
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		return entries;
	}
	
	@Override
	public Set<K> keySet() {
		return keysSet;
	}
	@Override
	public V put(K key, V value) {
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
	public V get(Object key) { // Key is type Object, not k
		if (!keys.contains(key)) {
			return null;
		}
		return values.get(keys.indexOf(key));
	}
	private class EntrySet extends AbstractSet<Map.Entry<K,V>>{
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
	public void clear() {
		keys.clear();
		values.clear();
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
		return entrySet().hashCode();
	}
	
	@Override
	public int size() {
		return keys.size();
	}
	
	@Override
	public boolean isEmpty() {
		return entrySet().isEmpty();
	}
	
	
	@Override
	public Collection<V> values() {
		return values;
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
	public V remove(Object key) {
		V v = get(key);
		int i = keys.indexOf(key);
		keys.remove(i);
		values.remove(i);
		return v;
	}
	
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (Map.Entry<? extends K, ? extends V> me : m.entrySet()) {
			put(me.getKey(), me.getValue());
		}
	}
	
	public static void main(String[] args) {
		SlowMap17<String, String> m = new SlowMap17<>();
		m.putAll(Countries.capitals(15));
		print("m: " + m);
		print("m.get(\"BURUNDI\"): " + m.get("BURUNDI"));
		print("m.entrySet(): " + m.entrySet());
		print("m.keySet(): " + m.keySet());
		print("m.values() = " + m.values());
		print("Two different maps: ");
		SlowMap17<String, String> m2 = new SlowMap17<>();
		print("m.equals(m2): " + m.equals(m2));
		m2.putAll(Countries.capitals(15));
		print("Maps with same entries: ");
		print("m.equals(m2): " + m.equals(m2));
		m.clear();
		print("After m.clear(), m.isEmpty(): " + m.isEmpty() + ", m = " + m);
		m2.keySet().clear();
		print("After m2.keySet().clear(), m2.isEmpty(): " + m2.isEmpty() +", m2 = " + m2);
	}
}
