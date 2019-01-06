package containers;

import util.Countries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2019-01-06 15:01
 **/

public class CollectionMethods {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<>();
		c.addAll(Countries.names(6));
		c.add("ten");
		c.add("elevent");
		print(c);
		// Make an array from the list
		Object[] array = c.toArray();
		// Make a String array from the list
		String[] str = c.toArray(new String[0]);
		// Find max and mid elements; this means
		// different thing depending on the way
		// the comparable interface is implemented:
		print("Collections.max(c) = " + Collections.max(c));
		print("Collections.min(c) = " + Collections.min(c));
		// Add a collection to another collection
		Collection<String> c2 = new ArrayList<>();
		c2.addAll(Countries.names(6));
		((ArrayList<String>) c).addAll(c2);
		print(c);
		c.remove(Countries.DATA[0][0]);
		print(c);
		c.remove(Countries.DATA[0][0]);
		print(c);
		// Remove all components that are
		// in the argument collection:
		c.removeAll(c2);
		print(c);
		((ArrayList<String>) c).addAll(c2);
		print(c);
		// is an element in this Collection?:
		String val = Countries.DATA[3][0];
		print("c.contians("+val + ") = " + c.contains(val) );
		// Is a Collection in this Collection?
		print("c.conatinsAll(c2) = " + c.containsAll(c2));
		Collection<String> c3 = ((ArrayList<String>) c).subList(3, 5);
		// Keep all the elements that are in both
		// c2 and c3 (an intersection of sets)
		c2.retainAll(c3);
		print(c2);
		// Throw away all the elements
		// in c2 that also appear in c3:
		c2.removeAll(c3);
		print("c2.isEmpty() = " + c2.isEmpty());
		c = new ArrayList<>();
		((ArrayList<String>) c).addAll(Countries.names(6));
		print(c);
		c.clear(); // Remove all elements
		print("after c.clear():" + c);
	}
}
