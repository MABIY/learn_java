package containers;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2019-01-06 17:29
 **/

interface SListIterator<T>{
	boolean hasNext();
	
	T next() throws NoSuchMethodException;
	
	void remove() throws IllegalAccessException;
	
	void add(T element);
}

class SList<T> {
	// Utilization of  hte 'Null Object' pattern
	private final Link<T> header = new Link<T>(null, null);
	SList() {
		header.next = header;
	}
	
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("[");
		for (SListIterator<T> it = iterator(); it.hasNext(); ) {
			T element = null;
			try {
				element = it.next();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
			buf.append(element == this ? "(this Slist)" : String.valueOf(element));
			if (it.hasNext()) {
				buf.append(", ");
			}
		}
		buf.append("]");
		return buf.toString();
	}
	
	public SListIterator<T> iterator() {
		return new SListIteratorImpl();
	}
	
	private class Link<T> {
		T element;
		Link<T> next;
		public Link(T element, Link<T> next) {
			this.element = element;
			this.next = next;
		}
	}
	
	private class SListIteratorImpl implements SListIterator<T>{
		private Link<T> lastReturned = header;
		private Link<T> next;
		
		public SListIteratorImpl() {
			next = header.next;
		}
		
		@Override
		public T next() throws NoSuchMethodException {
			if (next == header) {
				throw new NoSuchMethodException();
			}
			lastReturned = next;
			next = next.next;
			return lastReturned.element;
		}
		
		@Override
		public void remove() throws IllegalAccessException {
			if (lastReturned == header) {
				throw new IllegalAccessException();
			}
			// Find an element before the last returned one
			for (Link<T> curr = header; ; curr = curr.next) {
				if (curr.next == lastReturned) {
					curr.next = lastReturned.next;
					break;
				}
			}
			lastReturned = header;
		}
		
		@Override
		public boolean hasNext() {
			return next != header;
		}
		
		@Override
		public void add(T element) {
			lastReturned = header;
			Link<T> newLink = new Link<>(element, next);
			if (header.next == header) { // Empty list
				header.next = newLink;
			} else {
				// Find an element before the one pointed by 'next'
				for (Link<T> curr = header; ; curr = curr.next) {
					if (curr.next == next) {
						curr.next = newLink;
						break;
					}
				}
			}
			
		}
	}
}
public class E08_SList {
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
		// First ,show some use case for SListIterator
		print("Demonstrating SListIterator... ");
		SList<String> sl = new SList<>();
		print(sl);
		SListIterator<String> slit = sl.iterator();
		slit.add("One");
		slit.add("Two");
		slit.add("Three");
		print(slit.hasNext());
		print(sl);
		slit = sl.iterator();
		slit.add("Four");
		for (; slit.hasNext(); ) {
			print(slit.next());
		}
		print(sl);
		slit = sl.iterator();
		print(slit.next());
		slit.remove();
		print(slit.next());
		print(sl);
		// Now ,Show the same use cases For ListIterator, too
		print(System.lineSeparator()+"Demonstrating ListItearot...");
		List<String> l = new ArrayList<>();
		print(l);
		ListIterator<String> lit = l.listIterator();
		lit.add("One");
		lit.add("Two");
		lit.add("Three");
		print(lit.hasNext());
		print(l);
		lit = l.listIterator();
		lit.add("Four");
		for (; lit.hasNext(); ) {
			print(lit.next());
		}
		print(l);
		lit = l.listIterator();
		print(lit.next());
		lit.remove();
		print(lit.next());
		print(l);
	}
}
