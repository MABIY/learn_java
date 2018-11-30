package typeinfo;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-29 16:52
 * Write a program to determine whether an array
 * of char is a primitive type of a true object
 **/
public class E10_PrimitiveOrTrue {
	public static void main(String[] args) {
		char[] ac = "Hello, World!".toCharArray();
		print("ac.getClass() = " + ac.getClass());
		print("ac.getClass().getSuperclass() = "+
				ac.getClass().getSuperclass());
		char c = 'c';
		//c.getClass(); // Can't do it ,primitives
		//lhtd
		int[] ia = new int[3];
		print("ia.getClasss() = " + ia.getClass());
		long[] la = new long[3];
		print("la.getClass() = " + la.getClass());
		double[] da = new double[3];
		print("da.getClass() = " + da.getClass());
		String[] sa = new String[3];
		print("sa.getClass() = " + sa.getClass());
		E10_PrimitiveOrTrue[] pot = new E10_PrimitiveOrTrue[3];
		print("pot.getClass() = " + pot.getClass());
		//Multi-dimensional arrays:
		int[][][] threed = new int[3][][];
		print("threed.getClass() = " + threed.getClass());
	}
}
