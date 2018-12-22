package arrays;

import java.util.Arrays;

/**
 * @author: liuHua
 * @create: 2018-12-22 19:17
 **/

public class ThreeDWithNew {
	public static void main(String[] args) {
		// 3-D array with fixed length:
		int[][][] a = new int[2][2][4];
		System.out.println(Arrays.deepToString(a));
	}
}
