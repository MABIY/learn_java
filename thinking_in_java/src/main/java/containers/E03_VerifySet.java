package containers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import static net.lh.util.Countries.names;

/**
 * @author lh
 * Using Countries, fill a Set with same data
 * multiple itmes, thenn verify that the set ends up
 * with only one of each instance, try this with
 * HashSet ,LinkedHashSet, and TreeSet
 **/
public class E03_VerifySet {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            set.addAll(names(10));
            set1.addAll(names(10));
            set2.addAll(names(10));
        }
        System.out.println(set);
        System.out.println(set1);
        System.out.println(set2);
    }
}
