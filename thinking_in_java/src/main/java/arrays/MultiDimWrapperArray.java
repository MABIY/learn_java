package arrays;

import java.util.Arrays;

/**
 * @author lh
 * multidimensional arrays of "wrapper" objects.
 **/
public class MultiDimWrapperArray {
    public static void main(String[] args) {
        Integer[][] a1 = { // Autoboxing
                {1, 2, 3},
                {4, 5, 6}
        };
        Double[][][] a2 = { // Autoboxing
                {
                        {1.1, 2.2}, {3.3, 4.4}
                },
                {
                        {5.5, 6.6},
                        {7.7, 8.8}
                },
                {
                        {9.9, 1.2},
                        {2.3, 3.4}
                }
        };
        String[][] a3 = {
                {"The", "Quick", "Sly", "Fox"},
                {"Jumped", "Over"},
                {"The", "Lazy", "Brown", "Dog", "and", "Fiend"}
        };
        System.out.println("a1: " + Arrays.deepToString(a1));
        System.out.println("a2: " + Arrays.deepToString(a2));
        System.out.println("a3: " + Arrays.deepToString(a3));
    }
}