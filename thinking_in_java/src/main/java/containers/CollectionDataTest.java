package containers;

import generics.util.Generator;
import util.CollectionData;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author: liuHua
 * @create: 2018-12-28 20:36
 **/

class Government implements Generator<String> {
	String[] foundation = ("strange women lying in ponds " +
			"distributing swords is no basis for a system of " +
			"government").split(" ");
	private int index;
	
	@Override
	public String next() {
		return foundation[index++];
	}
	
}
public class CollectionDataTest {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>(
				new CollectionData<>(new Government(), 15)
		);
		set.addAll(CollectionData.list(new Government(), 15));
		System.out.println(set);
	}
}
