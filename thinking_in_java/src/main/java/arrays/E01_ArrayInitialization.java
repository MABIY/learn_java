package arrays;

import com.sun.jndi.ldap.Ber;

/**
 * @author: liuHua
 * @create: 2018-12-22 16:55
 * Create a method that takes an array of
 * BerylliumSphere as an argument. Call the method,
 * creating the argument dynamically. Demonstrate
 **/

public class E01_ArrayInitialization {
	static void hide(BerylliumSphere[] s) {
		System.out.println("Hiding " + s.length + " sphere(s)");
	}
	
	public static void main(String[] args) {
		// Dynamic aggregate initialization:
		hide(new BerylliumSphere[]{
				new BerylliumSphere(),
				new BerylliumSphere()
		});
		
		// The following line produces a compilation error.
		// hide({new BerylliumSphere()});
		BerylliumSphere[] d = {
				new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()
		};
		hide(d);
		// Dynamic aggregate initialization is redundant
		// in hte next case:
		BerylliumSphere[] a = new BerylliumSphere[]{
				new BerylliumSphere(), new BerylliumSphere()
		};
		hide(a);
	}
}
