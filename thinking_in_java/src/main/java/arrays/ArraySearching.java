package arrays;

import net.lh.util.ConvertTo;
import net.lh.util.Generated;
import net.lh.util.Generator;
import net.lh.util.RandomGenerator;

import java.util.Arrays;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Using Array.binarySearch()
 **/
public class ArraySearching {
    public static void main(String[] args) {
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        int[] a = ConvertTo.primitive(
                Generated.array(new Integer[25], gen));

        Arrays.sort(a);
        print("Sorted array: " + Arrays.toString(a));
        while (true) {
            int r = gen.next();
            int location = Arrays.binarySearch(a, r);
            if (location >= 0) {
                print("Location of " + r + " is " + location + ", a[" + location + "] = " + a[location]);
                break; // Out of while loop
            }
        }
    }
}
