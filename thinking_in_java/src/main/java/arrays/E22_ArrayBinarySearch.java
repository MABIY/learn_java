package arrays;

import generics.util.Generator;
import util.RandomGenerator;

import java.util.Arrays;

import static access.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @author: liuHua
 * @create: 2018-12-28 16:27
 *
 **/

public class E22_ArrayBinarySearch {
	public static void main(String[] args) {
		Generator<Integer> gen = new RandomGenerator.Integer(1000);
		int[] a = ConvertTo.primitive(
				Generated.array(new Integer[25], gen)
		);
		print("Unsortd array: " + Arrays.toString(a));
		
		int location = Arrays.binarySearch(a, a[10]);
		printnb("Location of " + a[10] + " is " + location);
		if (location >= 0) {
			print(", a[" + location + "] = " + a[location]);
		} else {
			print();
		}
		location = Arrays.binarySearch(a, a[5]);
		print("Location of " + a[5] + " is " + location);
		
		if (location >= 0) {
			print(", a[" + location + "] = " +a[location] );
		}
	}
}
