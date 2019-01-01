package containers;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static util.Countries.capitals;
import static util.Countries.names;

/**
 * @author: liuHua
 * @create: 2019-01-01 17:14
 **/

public class E02_ACountries {
	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<>(capitals());
		TreeSet<String> set = new TreeSet<>(names());
		String b = null;
		for (String s : map.keySet()) {
			if (s.startsWith("B")) {
				b = s;
				break;
			}
		}
		Map<String, String> aMap = map.headMap(b);
		Set<String> aSet = set.headSet(b);
		System.out.println("aMap = " + aMap);
		System.out.println("aSet = " + aSet);
	}
}
