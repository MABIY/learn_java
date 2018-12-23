package arrays;

import java.util.Arrays;

/**
 * @author: liuHua
 * @create: 2018-12-22 19:14
 * Creating multidimensional arrays
 **/

public class MultidimensionalPrimitiveArray {
	public static void main(String[] args) {
		int[][] a = {
				{1, 2, 3,},
				{4, 5, 6,}
		};
		System.out.println(Arrays.deepToString(a));
	}
}