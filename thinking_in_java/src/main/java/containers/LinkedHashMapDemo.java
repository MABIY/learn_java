package containers;

import java.util.LinkedHashMap;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2019-01-10 15:23
 **/

public class LinkedHashMapDemo {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(
				new CountingMapData(9)
		);
		print(linkedMap);
		// Least-recently-used order
		linkedMap = new LinkedHashMap<>(16, 0.75f, true);
		linkedMap.putAll(new CountingMapData(9));
		print(linkedMap);
		for (int i = 0; i < 6; i++) { // Cause accesses
			linkedMap.get(i);
		}
		print(linkedMap);
		System.out.println(linkedMap.get(0));
		print(linkedMap);
		System.out.println(linkedMap.get(0));
	}
}
