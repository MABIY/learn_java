package containers;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @author: liuHua
 * @create: 2019-01-10 14:42
 **/

public class E14_PropertiesDemo {
	static void printKeys(Map<Object, Object> map) {
		printnb("Size = " + map.size() + ", ");
		printnb("Keys: ");
		print(map.keySet()); // Produce a Set of the keys
	}
	
	static void test(Map<Object, Object> map) {
		print(map.getClass().getSimpleName());
		map.putAll(new CountingMapData(25));
		// Map has 'Set' behavior for keys
		map.putAll(new CountingMapData(25));
		// Producing a Collection of the values:
		printnb("Values: ");
		print(map.values());
		print(map);
		print("map.containsKey(11): " + map.containsKey(11));
		print("map.get(11): " + map.get(11));
		print("map.containsValue(\"F0\")): " +
				map.containsValue("F0"));
		Object key = map.keySet().iterator().next();
		print("First key in map: " + key);
		map.remove(key);
		printKeys(map);
		map.clear();
		print("map.isEmpty(): " + map.isEmpty());
		map.putAll(new CountingMapData(25));
		// Operations on the Set change the map:
		Set<Object> stringSet = map.keySet();
		stringSet.removeAll(map.keySet());
		print("map.isEmpty(): " + map.isEmpty());
	}
	
	public static void main(String[] args) {
		test(new Properties());
	}
}