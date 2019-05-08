package holding;

import sun.awt.image.ImageWatched;

import java.util.*;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Write a method that uses an Iterator to step through a Collection and
 * print the toString() of each object in the container. Fill all the differnet
 * types of Collections with objects and apply your method so each container.
 **/
public class Ex11 {
    public static void printAny(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            print(it.next() + " ");
        }
        print();
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(
                1, 2, 3
        ));
        LinkedList<Character> ll = new LinkedList<>(Arrays.asList('a', 'b', 'c'));
        HashSet<Float> hs = new HashSet<Float>(Arrays.asList(
                1.1f, 2.2f, 3.3f
        ));
        TreeSet<Double> ts = new TreeSet<>(Arrays.asList(
                1.11, 2.22, 3.33
        ));
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>(Arrays.asList(
                11, 222, 33
        ));

        printAny(al);
        printAny(ll);
        printAny(ts);
        printAny(lhs);
    }
}
