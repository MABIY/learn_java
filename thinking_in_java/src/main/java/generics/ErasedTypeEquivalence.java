package generics;

import java.util.ArrayList;

/**
 * @author: liuHua
 * @create: 2018-12-06 17:01
 **/

public class ErasedTypeEquivalence {
	public static void main(String[] args) {
		Class c1 = new ArrayList<String>().getClass();
		Class c2 = new ArrayList<Integer>().getClass();
		System.out.println(c1 == c2);
	}
}
