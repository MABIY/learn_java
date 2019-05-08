package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Create and populate a List<Integer>.Create a second List<Integer> of hte
 * same size as the first, and use ListIterator to read elements of the first
 * List and insert them into the second in reverse order. (You may want to
 * explore a number of different ways to solve this problem.)
 **/
public class Ex12a {
    public static void main(String[] args) {
        List<Integer> li1 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        List<Integer> li2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9));
        //start it1 at the end:
        ListIterator<Integer> it1 = li1.listIterator(5);
        ListIterator<Integer> it2 = li2.listIterator();
        print("li1: " + li1);
        print("li2: " + li2);
        // now use it2 to re-set li2
        while (it2.hasNext()) {
            it2.next();
            it2.set(it1.previous());
        }
        print("li1: " + li1);
        print("li2: " + li2);
    }
}
