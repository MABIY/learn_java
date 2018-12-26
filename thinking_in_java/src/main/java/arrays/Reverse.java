package arrays;

import java.util.Arrays;
import java.util.Collections;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-26 17:16
 **/

public class Reverse {
	public static void main(String[] args) {
		CompType[] a = Generated.array(
				new CompType[12], CompType.generator()
		);
		print("before sorting: ");
		print(Arrays.toString(a));
		Arrays.sort(a, Collections.reverseOrder());
		print("after sorting: ");
		print(Arrays.toString(a));
	}
}
