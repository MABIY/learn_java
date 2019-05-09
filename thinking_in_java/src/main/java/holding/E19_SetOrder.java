package holding;

import net.mindview.util.Countries;

import java.util.*;

/**
 * @author lh
 * Repeat Exercise 18 with a HashSet and LinkedHashSet.
 **/
public class E19_SetOrder {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>(Countries.names(25));
        System.out.println(s1);
        String[] elements = s1.toArray(new String[0]);
        Arrays.sort(elements);
        Set<String> s2 = new LinkedHashSet<>();
        for (String element : elements) {
            s2.add(element);
        }
        System.out.println(s2);
}
}
