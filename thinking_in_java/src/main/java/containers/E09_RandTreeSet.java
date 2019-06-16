package containers;

import net.lh.util.CollectionData;
import net.lh.util.RandomGenerator;

import java.util.TreeSet;

/**
 * @author lh
 * Use RandomGenerator.String to fill a TreeSet,
 * but use alphabetic ordering. Print the TreeSet
 * to verify the sort order.
 **/
public class E09_RandTreeSet {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        ts.addAll(CollectionData.list(new RandomGenerator.String(), 10));
        System.out.println("ts = " + ts);
    }
}
