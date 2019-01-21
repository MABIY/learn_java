package containers;

import util.Countries;

import java.util.*;

/**
 * @author: liuHua
 * @create: 2019-01-15 16:29
 **/

public class E21_LeftReader<K,V> extends AbstractMap<K,V> {
	// Choose a prime number  for the hash table
	// size , to achieve a uniform distribution:
	static final int SIZE = 997;
	// You can't have a physical array of generics,
	// but you can upcast to one
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
	
	@Override
	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null) {
			buckets[index] = new LinkedList<>();
		}
		LinkedList<MapEntry<K, V>> bucket = buckets[index];
		MapEntry<K, V> pair = new MapEntry<>(key, value);
		boolean found = false;
		ListIterator<MapEntry<K, V>> it = bucket.listIterator();
		int probes = 0;
		while (it.hasNext()) {
			MapEntry<K, V> iPair = it.next();
			probes++;
			if (iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				it.set(pair); //Replace old with new
				found = true;
				System.out.println("Collision at " + iPair + ": " + probes + " probe"
						+ ((probes == 1) ? "" : "s") + " needed");
			}
		}
		if (!found) {
			buckets[index].add(pair);
		}
		return oldValue;
	}
	
	@Override
	public V get(Object key) {
		int index = Math.abs(key.hashCode() % SIZE);
		if (buckets[index] == null) {
			return null;
		}
		for (MapEntry<K, V> iPair : buckets[index]) {
			if (iPair.getKey().equals(key)) {
				return iPair.getValue();
			}
		}
		return null;
	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<>();
		for (LinkedList<MapEntry<K, V>> bucket : buckets) {
			if (bucket == null) {
				continue;
			}
			for (MapEntry<K, V> mpair : bucket) {
				set.add(mpair);
			}
		}
		return set;
	}
	
	public static void main(String[] args) {
		E21_LeftReader<String, String> m = new E21_LeftReader<>();
		m.putAll(Countries.capitals(5));
		System.out.println(m);
		m.put("EGYPT", "Berlin?");
		m.put("EGYPT", "New York?");
		m.put("EGYPT", "Cairo");
		System.out.println();
		m.putAll(Countries.capitals(6));
		System.out.println(m);
	}
}
