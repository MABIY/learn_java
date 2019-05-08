package holding;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author lh
 * Modify innerclasses/Sequence.java so that Sequence works with an Iterator
 * instead of a Selector
 **/
public class Sequence9 {
    private ArrayList<Object> items = new ArrayList<>();

    public void add(Object x) {
        items.add(x);
    }

    public Iterator iterator() {
        return items.iterator();
    }

    public static void main(String[] args) {
        Sequence9 sequence9 = new Sequence9();
        for (int j = 0; j < 10; j++) {
            sequence9.add(Integer.toString(j));
        }
        Iterator it = sequence9.iterator();
        while (it.hasNext()) {
            System.out.println(it.next() + " ");
        }
    }
}
