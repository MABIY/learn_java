package containers;

import strings.ArrayListDisplay;
import util.CollectionData;
import util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author: liuHua
 * @create: 2018-12-28 20:44
 **/

public class CollectionDataGeneration {
	public static void main(String[] args) {
		System.out.println(new ArrayList<String>(
				CollectionData.list( // Convenience method
						new RandomGenerator.String(9), 10
				)
		));
		
		System.out.println(new HashSet<Integer>(
				new CollectionData<>(new RandomGenerator.Integer(), 10)
		));
	}
}
