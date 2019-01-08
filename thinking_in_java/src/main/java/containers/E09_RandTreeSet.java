package containers;

import util.CollectionData;
import util.RandomGenerator;

import java.util.TreeSet;

/**
 * @author: liuHua
 * @create: 2019-01-08 08:23
 **/

public class E09_RandTreeSet {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		ts.addAll(CollectionData.list(
				new RandomGenerator.String(), 10
		));
		System.out.println("ts = " + ts);
	}
}
