package arrays;

import util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-28 16:00
 **/

public class StringSorting {
	public static void main(String[] args) {
		String[] sa = Generated.array(new String[20], new RandomGenerator.String(5));
		print("Before sort: " + Arrays.toString(sa));
		Arrays.sort(sa);
		print("After sort: " + Arrays.toString(sa));
		Arrays.sort(sa, Collections.reverseOrder());
		print("Reverse sort:" + Arrays.toString(sa));
		Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
		print("case-insensitive sort: " +Arrays.toString(sa));
	}
}
