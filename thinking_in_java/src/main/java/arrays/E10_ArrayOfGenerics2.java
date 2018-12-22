package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-22 21:40
 **/

public class E10_ArrayOfGenerics2 {
	public static void main(String[] args) {
		ArrayList<List<String>> ls = new ArrayList<>();
		ls.add(new ArrayList<>());
		// Compile-time checking produces an error:
		// ls.add(new ArrayList<Integer>());
		ls.get(0).add("Array of Generics");
		System.out.println(ls.toString());
	}
}
