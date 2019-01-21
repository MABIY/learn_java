package containers;

import org.jetbrains.annotations.NotNull;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author: liuHua
 * @create: 2019-01-21 13:26
 * Following the example in SimpleHashMap.java
 * create and test a SimpleHashSet
 **/

class SimpleHashSet<K> extends AbstractSet<K>{
	private final static int SIZE = 997;
	
	@SuppressWarnings("unchecked")
	private LinkedList<K>[] buckets = new LinkedList[SIZE];
	
	@Override
	public boolean add(K key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null) {
			buckets[index] = new LinkedList<>();
		}
		LinkedList<K> bucket = buckets[index];
		ListIterator<K> it = bucket.listIterator();
		while (it.hasNext()) {
			if (it.next().equals(key)) {
				return false;
			}
		}
		// Sets do not permit duplicates and one
		// was already in the set
			it.add(key);
			return true;
	}
	
	@Override
	public boolean contains(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null) {
			return false;
		}
		Iterator<K> it = buckets[index].iterator();
		while (it.hasNext()) {
			if (it.next().equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int size() {
		int sz = 0;
		for (LinkedList<K> bucket : buckets) {
			if (bucket != null) {
				sz += bucket.size();
			}
		}
		return sz;
	}
	
	@Override
	public Iterator<K> iterator() {
	
	}
}
public class E24_SimpleHashSet {

}
