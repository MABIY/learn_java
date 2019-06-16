package containers;

import net.lh.util.Countries;

import java.util.*;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Create both an ArrayList and a LinkedList, and
 * fill each using the Countries.names() generator.
 * Print each list using an ordinary Iterator,then
 * insert one list into the other by using a ListIterator,
 * inserting at every other location.
 * Now perform the insertiong starting at the end of the first
 * list and movingf backward.
 **/
public class E07_CrossInsertion {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>(Countries.names(10));
        LinkedList<String> ll = new LinkedList<>(Countries.names(20).subList(10,20));
        for (Iterator<String> it = al.iterator(); it.hasNext(); ) {
            print(it.next());
        }
        print("*****");
        for (Iterator<String> it = ll.iterator(); it.hasNext();) {
            print(it.next());
        }
        print("*****");
        int alindex = 0;
        for (ListIterator<String> lit2 = ll.listIterator(); lit2.hasNext();) {
            al.add(alindex, lit2.next());
            alindex += 2;
        }
        print("a1 = " + al);
        print("******");
        alindex = 0;
        // Start at hte end:
        for (ListIterator<String> lit2 = ll.listIterator(ll.size()); lit2.hasPrevious(); ) {
            al.add(alindex, lit2.previous());
            alindex += 2;
        }
        print("al = " + al);
    }
}
