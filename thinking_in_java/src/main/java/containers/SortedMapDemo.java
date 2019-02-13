package containers;

import java.util.Iterator;
import java.util.TreeMap;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2019-01-10 15:08
 **/

public class SortedMapDemo {
	public static void main(String[] args) {
		TreeMap<Integer, String> sortedMap = new TreeMap<>(new CountingMapData(10));
		print(sortedMap);
		Integer low = sortedMap.firstKey();
		Integer high = sortedMap.lastKey();
		print(low);
		print(high);
		Iterator<Integer> it = sortedMap.keySet().iterator();
		for (int i = 0; i < 6; i++) {
			if (i == 3) {
				low = it.next();
			}
			if (i == 6) {
				high = it.next();
			} else {
				it.next();
			}
		}
		
		print(low);
		print(high);
		print(sortedMap.subMap(low, high));
		print(sortedMap.headMap(high));
		print(sortedMap.tailMap(low));
	}
}