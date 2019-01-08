package containers;


import java.util.*;

import static access.util.Print.print;
import static java.util.Collections.binarySearch;
import static java.util.Collections.reverseOrder;


/**
 * @author: liuHua
 * @create: 2019-01-08 08:31
 **/

class CustomSortedSet<T> implements SortedSet<T> {
	private final List<T> list;
	
	public CustomSortedSet() {
		list = new LinkedList<>();
	}
	
	// if this sorted set is backed by an another one
	private CustomSortedSet(List<T> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return list.toString();
	}
	
	/**
	 * Methods defined in the SortedSet interface
	 * @return
	 */
	@Override
	public Comparator<? super T> comparator() {
		return null;
	}
	
	@Override
	public SortedSet<T> subSet(T fromElement, T toElement) {
		checkForNull(fromElement);
		checkForNull(toElement);
		int fromIndex = list.indexOf(fromElement);
		int toIndex = list.indexOf(toElement);
		try {
			checkForValidIndex(fromIndex);
			checkForValidIndex(toIndex);
			return new CustomSortedSet<T>(list.subList(fromIndex, toIndex));
		} catch (IllegalAccessException | IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	@Override
	public SortedSet<T> headSet(T toElement) {
		checkForNull(toElement);
		int toIndex = list.indexOf(toElement);
		try {
			checkForValidIndex(toIndex);
			return new CustomSortedSet<T>(list.subList(0, toIndex));
		} catch (IllegalAccessException | IndexOutOfBoundsException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	@Override
	public SortedSet<T> tailSet(T fromElement) {
		checkForNull(fromElement);
		int fromIndex = list.indexOf(fromElement);
		try {
			checkForValidIndex(fromIndex);
			return new CustomSortedSet<T>(
					list.subList(fromIndex, list.size())
			);
		} catch (IllegalAccessException | IndexOutOfBoundsException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	@Override
	public T first() {
		try {
			return list.get(0);
		} catch (IndexOutOfBoundsException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public T last() {
		try {
			return list.get(list.size() - 1);
		} catch (IndexOutOfBoundsException e) {
			throw new RuntimeException(e);
		}
	}
	
	/***
	 *  Methods defined in the Collection interface
	 * @return
	 */
	@Override
	public int size() {
		return list.size();
	}
	
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	@Override
	public boolean contains(Object o) {
		checkForNull(o);
		return binarySearch((List<Comparable<T>>) list, (T) o) >= 0; //lhtd
	}
	
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}
	
	@Override
	public Object[] toArray() {
		return list.toArray();
	}
	
	@Override
	public <T> T[] toArray(T[] a) {
		return list.toArray(a);
	}
	
	@Override
	public boolean add(T t) {
		checkForNull(t);
		int ip = binarySearch((List<Comparable<T>>)list, t);
		if (ip < 0) {
			ip = -(ip + 1);
			if (ip == list.size()) {
				list.add(t);
			}else{
				list.add(ip, t);
			}
			return true;
		}
		return false;
	}
	
	@Override
	public boolean remove(Object o) {
		checkForNull(o);
		return list.remove(o);
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		checkForNull(c);
		return list.containsAll(c);
	}
	
	@Override
	public boolean addAll(Collection<? extends T> c) {
		checkForNull(c);
		checkForNullElements(c);
		boolean res = false;
		for (T item : c) {
			res |= add(item);
		}
		return res;
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		checkForNull(c);
		return list.removeAll(c);
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		checkForNull(c);
		return list.retainAll(c);
	}
	
	@Override
	public void clear() {
		list.clear();
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof CustomSortedSet && list.equals(((CustomSortedSet<?>) obj).list);
	}
	
	@Override
	public int hashCode() {
		return list.hashCode();
	}
	
	/***
	 *  Utility methods
	 */
	private void checkForNullElements(Collection<?> c) {
		for (Iterator<?> it = c.iterator(); ((Iterator) it).hasNext(); ) {
			if (it.next() == null) {
				throw new NullPointerException();
			}
		}
	}
	
	private void checkForNull(Object o) {
		if (o == null) {
			throw new NullPointerException();
		}
	}
	
	private void checkForValidIndex(int idx) throws IllegalAccessException {
		if (idx == -1) {
			throw new IllegalAccessException();
		}
	}
}
public class E10_CustomSortedSet {
	// The whole main() method is basically copy-pasted from
	// containers/SortedSetDemo.java!
	public static void main(String[] args) {
		SortedSet<String> sortedSet = new CustomSortedSet<>();
		Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
		print(sortedSet);
		
		String low = sortedSet.first();
		String hight = sortedSet.last();
		print(low);
		print(hight);
		Iterator<String> it = sortedSet.iterator();
		for (int i = 0; i < 6; i++) {
			if (i == 3) {
				low = it.next();
			}
			if (i == 6) {
				hight = it.next();
			} else {
				it.next();
			}
		}
		print(low);
		print(hight);
		print(sortedSet.subSet(low, hight));
		print(sortedSet.headSet(hight));
		print(sortedSet.tailSet(low));
		print(sortedSet.contains("three"));
		print(sortedSet.contains("eleven"));
		print(sortedSet.addAll(
				Arrays.asList("three","eleven")
		));
		print(sortedSet);
		// Demonstrate data integrity
		try {
			sortedSet.addAll(Arrays.asList("zero", null));
		} catch (NullPointerException e) {
			System.out.println("Null element not supported!");
		}
		// The set will not contain "zero"!
		print(sortedSet);
	}
}
