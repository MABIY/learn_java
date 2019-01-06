package containers;

import util.Countries;

import java.util.*;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2019-01-06 16:52
 **/

public class E07_CrossInsertion {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>(Countries.names(10));
		LinkedList<String> ll = new LinkedList<>(
				Countries.names(20).subList(10, 20)
		);
		for (Iterator<String> it = al.iterator(); it.hasNext();) {
			print(it.next());
		}
		print("****");
		for (Iterator<String> it = ll.iterator(); it.hasNext(); ) {
			print(it.next());
		}
		print("****");
		int alindex = 0;
		for (ListIterator<String> lit2 = ll.listIterator(); lit2.hasNext(); ) {
			al.add(alindex, lit2.next());
			alindex += 2;
		}
		
		print("a1 = " + al);
		print("****");
		alindex = 0;
		for (ListIterator<String> lit2 = ll.listIterator(ll.size()); lit2.hasPrevious();) {
			al.add(alindex, lit2.previous());
			alindex += 2;
		}
		print("al = " + al);
	}
}
