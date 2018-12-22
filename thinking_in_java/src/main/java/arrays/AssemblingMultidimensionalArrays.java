package arrays;

import java.util.Arrays;

/**
 * @author: liuHua
 * @create: 2018-12-22 19:40
 *  creating multidimensional arrays
 **/

public class AssemblingMultidimensionalArrays {
	public static void main(String[] args) {
		Integer[][] a;
		a = new Integer[3][];
		for (int i = 0; i < a.length; i++) {
			a[i] = new Integer[3];
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = i * j; //autoboxing
			}
		}
		System.out.println(Arrays.deepToString(a));
	}
}
