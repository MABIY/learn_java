package arrays;

import net.lh.util.Generated;
import net.lh.util.Generator;
import net.lh.util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Create an array of Integer, fill it with random int values (using autoboxing),
 * and sort it into reverse order using a comparator
 **/
public class E23_ArraySort2 {
    public static void main(String[] args) {
        Generator<Integer> gen = new RandomGenerator.Integer(10000);
        Integer[] a = Generated.array(new Integer[25], gen);
        print("Unsorted array: " + Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        print("Sorted array: " + Arrays.toString(a));
    }
}
