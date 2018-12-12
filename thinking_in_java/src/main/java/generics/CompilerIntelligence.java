package generics;

import java.util.Arrays;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-12 11:14
 **/

public class CompilerIntelligence {
	public static void main(String[] args) {
		List<? extends Fruit> flist =
				Arrays.asList(new Apple());
		Apple a = (Apple) flist.get(0); //No warning
		System.out.println(flist.contains(new Apple())); // Argument is 'Objectt'
		System.out.println(flist.indexOf(new Apple())); // Argument is 'Object'
	}
}
