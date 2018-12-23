package arrays;

import util.CountingGenerator;

import java.util.Arrays;

/**
 * @author: liuHua
 * @create: 2018-12-23 20:53
 **/

public class E12_GeneratedDArray {
	public static void main(String[] args) {
		double[] d = ConvertTo.primitive(Generated.array(
				Double.class, new CountingGenerator.Double(), 15
		));
		System.out.println(Arrays.toString(d));
	}
}
