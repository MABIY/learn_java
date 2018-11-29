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
	}
}
