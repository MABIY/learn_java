package containers;

import util.Countries;

import java.util.*;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2019-01-06 15:59
 **/

public class Lists {
	private static boolean b;
	private static String s;
	private static int i;
	private static Iterator<String> it;
	private static ListIterator<String> lit;
	
	public static void basicTest(List<String> a) {
		a.add(1, "x");  // Add at location 1
		a.add("x"); // Add at end
		// Add a collection:
		a.addAll(Countries.names(25));
		// Add a collection starting at location 3;
		a.addAll(3, Countries.names(25));
		b = a.contains("1");// Is it in there?
		// Is the entries collection in there?
		b = a.containsAll(Countries.names(25));
		// Lists allow random access, which is cheap
		// for ArrayList, expensive for LinkedList
		s = a.get(1); // Tell index of object
		i = a.indexOf("1");
		b = a.isEmpty();
		it = a.iterator(); // Ordinary iterator
		lit = a.listIterator();
		i = a.lastIndexOf("1"); // Last match
		a.remove(1);// Remove location 1
		a.remove("3"); // Remove this object
		a.set(1, "y");// Set location 1 to "y"
		// Keep everything that's in the argument
		// (the intersection of the two sets)
		a.retainAll(Countries.names(25));
		// Remove everything that' in the argument:
		a.removeAll(Countries.names(25));
		i = a.size(); // how big is it?
		a.clear(); // Remove all elements
	}
	
	public static void iterMotion(List<String> a) {
		ListIterator<String> it = a.listIterator();
		b = it.hasNext();
		b = it.hasPrevious();
		s = it.next();
		i = it.nextIndex();
		s = it.previous();
		i = it.previousIndex();
	}
	
	public static void iterManpulation(List<String> a) {
		ListIterator<String> it = a.listIterator();
		it.add("47");
		// Must move to an element after add()
		it.next();
		//Remove the element after the newly produced one:
		it.remove();
		// Must move to an element after remove():
		it.next();
		// Change the element after the deleted one:
		it.set("47");
	}
	
	public static void testVisual(List<String> a) {
		print(a);
		List<String> b = Countries.names(25);
		print("b = " + b);
		a.addAll(b);
		a.addAll(b);
		print(a);
		// Insert ,remove ,and replace elements
		// Using a ListIterator:
		ListIterator<String> x = a.listIterator(a.size() / 2);
		x.add("one");
		print(a);
		print(x.next());
		x.remove();
		print(x.next());
		x.set("47");
		print(a);
		// Tragverse the list backwards
		x = a.listIterator(a.size());
		while (x.hasPrevious()) {
			print(x.previous() + " ");
		}
		print();
		print("testVisual finished");
	}
	// There are some things that only LinkedLists can do:
	public static void testLikedList() {
		LinkedList<String> ll = new LinkedList<>();
		ll.addAll(Countries.names(25));
		print(ll);
		// Treat it like a stack, pushing
		ll.addFirst("one");
		ll.addFirst("Two");
		print(ll);
		// Like 'peeking' at the top of a stack
		print(ll.getFirst());
		// Like popping a stack
		
		print(ll.removeFirst());
		print(ll.removeFirst());
		// Treat it like a queue, pulling elements
		// off the tail end
		print(ll.removeLast());
		print(ll);
	}
	
	public static void main(String[] args) {
		// Make and fill a new List each time:
		basicTest(new LinkedList<>(Countries.names(25)));
		basicTest(
				new ArrayList<>(Countries.names(25))
		);
		iterMotion(
				new LinkedList<>(Countries.names(25))
		);
		iterMotion(
				new ArrayList<>(Countries.names(25))
		);
		iterManpulation(
				new LinkedList<>(Countries.names(25))
		);
		testVisual(new LinkedList<>(Countries.names(25)));
		testLikedList();
	}
	
}
