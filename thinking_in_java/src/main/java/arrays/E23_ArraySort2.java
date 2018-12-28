package arrays;

import generics.util.Generator;
import util.RandomGenerator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-28 16:40
 **/

public class E23_ArraySort2 {
	public static void main(String[] args) {
		Generator<Integer> gen = new RandomGenerator.Integer(1000);
		Integer[] a = Generated.array(new Integer[25], gen);
		print("Unsorted array: " + Arrays.toString(a));
		Arrays.sort(a, Collections.reverseOrder());
		print("Sorted array: " + Arrays.toString(a));
	}
}
