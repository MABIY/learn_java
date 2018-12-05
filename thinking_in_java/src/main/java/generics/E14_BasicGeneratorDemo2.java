package generics;

import control.Count;
import generics.util.BasicGenerator;
import generics.util.Generator;

/**
 * @author: liuHua
 * @create: 2018-12-05 15:41
 * Modify BasicGeneratorDemo.java to use the
 * explicit  form of creation for the Generator
 * (that is, use the explicit constructor instead
 * of the generic create() method)
 **/

public class E14_BasicGeneratorDemo2 {
	public static void main(String[] args) {
		Generator<CountedObject> gen = new BasicGenerator<>(CountedObject.class);
		for (int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
	}
}
