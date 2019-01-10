package util;

import java.util.LinkedList;

/**
 * @author: liuHua
 * @create: 2019-01-10 13:12
 **/

public class Deque<T> {
	private LinkedList<T> deque = new LinkedList<>();
	
	public void addFirst(T e) {
		deque.addFirst(e);
	}
	
	public void addLast(T e) {
		deque.addLast(e);
	}
	
	public T getFirst() {
		return deque.getFirst();
	}
	
	public T getLast() {
		return deque.getLast();
	}
	
	public T removeFirst() {
		return deque.removeFirst();
	}
	
	public T removeLast() {
		return deque.removeLast();
	}
	
	public int size() {
		return deque.size();
	}
	
	@Override
	public String toString() {
		return deque.toString();
}
}
