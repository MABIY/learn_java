package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-22 21:14
 **/

public class ArrayOfGenerics {
	public static void main(String[] args) {
		List<String>[] ls;
		List[] la = new List[10];
		ls = (List<String>[]) la; // "Unchecked" warning
		ls[0] = new ArrayList<>();
		// Compile-time checking produces an error
		// ls[1] = new ArrayList<Integer>();
		
		// The problem: List<String> is a subtype of object
		Object[] objects = ls;
		// Compiles and runs without complaint:
		objects[1] = new ArrayList<Integer>();
		
		//However , if you needs are straightforward it is
		// possible to create an array of generics,albert
		//with an "unchecked" warning
		List<BerylliumSphere>[] spneres = (List<BerylliumSphere>[]) new List[10];
		for (int i = 0; i < spneres.length; i++) {
			spneres[i] = new ArrayList<>();
		}
	}
}
