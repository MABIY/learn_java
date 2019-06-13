package arrays;

import net.lh.util.ConvertTo;
import net.lh.util.Generated;
import net.lh.util.Generator;
import net.lh.util.RandomGenerator;

import java.lang.reflect.Array;
import java.util.Arrays;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Show that the results of performing a
 * binarySearch() on an  unsorted array are
 * unpreditable
 **/
public class E22_ArrayBinarySearch {
    public static void main(String[] args) {
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        int[] a = ConvertTo.primitive(Generated.array(new Integer[25], gen));
        print("Unsorted array: " + Arrays.toString(a));
        int location = Arrays.binarySearch(a, a[10]);
        print("Location of " + a[10] + " is " + location);
        if (location >= 0) {
            print(", a[" + location + "] = " + a[location]);
        } else {
            print();
        }
        location = Arrays.binarySearch(a, a[5]);
        print("Location of " + a[5] + " is " + location);
        if (location >= 0) {
            print(", a[" + location + "] = " + a[location]);
        }
    }
}
