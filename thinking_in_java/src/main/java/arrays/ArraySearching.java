package arrays;

import generics.util.Generator;
import util.RandomGenerator;

import java.util.Arrays;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-28 16:10
 **/

public class ArraySearching {
	public static void main(String[] args) {
		Generator<Integer> gen = new RandomGenerator.Integer(1000);
		int[] a = ConvertTo.primitive(Generated.array(new Integer[25], gen));
		Arrays.sort(a);
		print("Sorted array: " + Arrays.toString(a));
		while (true) {
			int r = gen.next();
			int location = Arrays.binarySearch(a, r);
			if (location >= 0) {
				print("Location of " + r + " is " + location +
						", a[" + location + "] = " + a[location]);
				break; // Out of while loop
			}
		}
	}
}
