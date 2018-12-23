package arrays;

import operators.Bool;
import util.CountingGenerator;

import java.util.Arrays;

/**
 * @author: liuHua
 * @create: 2018-12-23 20:25
 **/

public class PrimitiveConversionDemonstration {
	public static void main(String[] args) {
		Integer[] a = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
		int[] b = ConvertTo.primitive(a);
		System.out.println(Arrays.toString(b));
		
		boolean[] c = ConvertTo.primitive(Generated.array(Boolean.class, new CountingGenerator.Boolean(), 7));
		System.out.println(Arrays.toString(c));
	}
}
