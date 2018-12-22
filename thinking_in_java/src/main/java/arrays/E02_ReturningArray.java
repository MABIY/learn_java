package arrays;

import java.util.Arrays;

/**
 * @author: liuHua
 * @create: 2018-12-22 18:01
 * Write a method that takes an int argument and
 * returns an array of that size, filled with
 * BerylliumSphere object
 **/

public class E02_ReturningArray {
	static BerylliumSphere[] createArray(int size) {
		BerylliumSphere[] a = new BerylliumSphere[size];
		for (int i = 0; i < size; i++) {
			a[i] = new BerylliumSphere();
		}
		return a;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(createArray(10)));
	}
}
