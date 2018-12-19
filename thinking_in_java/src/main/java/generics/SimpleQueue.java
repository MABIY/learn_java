package generics;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: liuHua
 * @create: 2018-12-19 17:01
 **/

public class SimpleQueue<T> implements Iterable<T> {
	private LinkedList<T> storage = new LinkedList<>();
	
	public void add(T t) {
		storage.offer(t);
	}
	
	public T get() {
		return storage.poll();
	}
	
	@Override
	public Iterator<T> iterator() {
		return storage.iterator();
	}
}
