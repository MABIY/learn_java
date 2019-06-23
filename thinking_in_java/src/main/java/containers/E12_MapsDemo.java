package containers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Substitute a HashMap, a TreeMap, and a LinkedHashMap
 * in AssociativeArray.java's main()
 **/
public class E12_MapsDemo {
    private static void test(Map<String, String> map) {
        map.put("skey", "blue");
        map.put("grass", "gree");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Never happen!
            print("Too many objects!");
        }
        print(map);
        print(map.get("ocean"));
    }

    public static void main(String[] args) {
        test(new HashMap<>());
        test(new TreeMap<>());
        test(new LinkedHashMap<>());
    }
}
