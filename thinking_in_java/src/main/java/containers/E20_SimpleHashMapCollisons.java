package containers;

import util.Countries;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author: liuHua
 * @create: 2019-01-15 16:06
 **/

class SimpleHashMap2<K,V> extends SimpleHashMap<K,V>{
	@Override
	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		MapEntry<K, V> pair = new MapEntry<>(key, value);
		if (buckets[index] == null) {
			buckets[index] = new LinkedList<>();
		} else {
			System.out.println("Collison while adding" + System.lineSeparator() + pair + System.lineSeparator() +
					"Bucket already contains:");
			Iterator<MapEntry<K, V>> it = buckets[index].iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		}
		// End of lines added
		LinkedList<MapEntry<K, V>> bucket = buckets[index];
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
			buckets[index].add(pair);
		}
		return oldValue;
	}
}
public class E20_SimpleHashMapCollisons {
	public static void main(String[] args) {
		SimpleHashMap2<String, String> m = new SimpleHashMap2<>();
		m.putAll(Countries.capitals(25));
		m.putAll(Countries.capitals(25));
		System.out.println(m);
	}
}
