package containers;

import java.util.Map;
import java.util.Properties;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Show that java.util.Properties works in the above
 * program (containers/Maps.java from the book)
 **/
public class E14_PropertiesDemo {
    static void printKeys(Map<Object, Object> map) {
        print("Size = " + map.size() +", ");
        print("Keys: ");
        print(map.keySet()); // Produce a Set of keys
    }

    static void test(Map<Object, Object> map) {
        print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        // Map has 'Set' behavior for keys:
        map.putAll(new CountingMapData(25));
        printKeys(map);
        // Producing a Collection of the values:
        print("Values: ");
        print(map.values());
        print(map);
        print("map.containsKey(11): " + map.containsKey(11));
        print("map.get(11): " + map.get(11));
        print("map.containsValue(\"F0\"): " + map.containsValue("F0"));
        Object key = map.keySet().iterator().next();
        print("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        print("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        // Operations on the Set change the map
        // Operations on the Set change the Map:
        print("map.isEmpty(): " + map.isEmpty());
    }

    public static void main(String[] args) {
        test(new Properties());

    }
}
