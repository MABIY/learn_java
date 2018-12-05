package generics;

import generics.util.New;

import java.util.List;
import java.util.Set;

/**
 * @author: liuHua
 * @create: 2018-12-05 13:44
 * Test New.java by creating your own classes and
 * ensuring that New will work properly with them.
 **/

public class E11_NewTest {
	public static void main(String[] args) {
		List<SixTuple<Byte, Short, String, Float, Double, Integer>> list = New.lList();
		list.add(
				new SixTuple<>((byte) 1, (short) 1, "A", 1.0F, 1.0, 1)
		);
		System.out.println(list);
		Set<Sequence<String>> set = New.set();
		set.add(new Sequence<>(5));
		System.out.println(set);
	}
}
