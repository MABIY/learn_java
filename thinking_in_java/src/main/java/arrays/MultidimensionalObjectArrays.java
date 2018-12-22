package arrays;

import java.util.Arrays;

/**
 * @author: liuHua
 * @create: 2018-12-22 19:33
 **/

public class MultidimensionalObjectArrays {
	public static void main(String[] args) {
		BerylliumSphere[][] spheres = {
				{new BerylliumSphere(), new BerylliumSphere()},
				{new BerylliumSphere(), new BerylliumSphere(),
						new BerylliumSphere(), new BerylliumSphere()},
				{
						new BerylliumSphere(), new BerylliumSphere(),
						new BerylliumSphere(), new BerylliumSphere(),
						new BerylliumSphere(), new BerylliumSphere(),
						new BerylliumSphere(), new BerylliumSphere()
				}
		};
		System.out.println(Arrays.deepToString(spheres));
	}
}
