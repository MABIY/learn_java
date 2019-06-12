package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 * Modify ArrayOfGenerics.java to use containers
 * instead of arrays. Show that you can eliminate
 * the compile-time warnings
 **/
public class E10_ArrayOfGenerics2 {
    public static void main(String[] args) {
        ArrayList<List<String>> ls = new ArrayList<>();
        ls.add(new ArrayList<>());
        // Compile-time checking produces an error:
        // ls.add(new ArrayList<Integer>());
        ls.get(0).add("Array of Generics");
        System.out.println(ls.toString());
    }
}
