package generics;

import generics.util.BasicGenerator;
import generics.util.Generator;

/**
 * @author: liuHua
 * @create: 2018-12-05 15:36
 **/

public class BasicGeneratorDemo {
	public static void main(String[] args) {
		Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
	}
}
