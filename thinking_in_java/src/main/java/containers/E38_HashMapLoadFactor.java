package containers;

import net.lh.util.Countries;

import java.util.HashMap;
import java.util.Map;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Look up the HashMap class in the JDK documentation.
 * Create a HashMap, fill it with elements, and determine
 * the load factor, Test the lookup speed
 * whit this map, then atempt to increase the speed
 * by marking a new HashMap with a larger initial capacity
 * and copying the old map into the new one,
 * then run your lookup speed test again on the new map
 **/
public class E38_HashMapLoadFactor {
    public static void testGet(Map<String, String> filledMap, int n) {
        for (int tc = 0; tc < 1000000; tc++) {
            for (int i = 0; i < Countries.DATA.length; i++) {
                String key = Countries.DATA[i][0];
                filledMap.get(key);
            }
        }
    }

    public static void main(String[] args) {
        // Initial capacity 16
        HashMap<String, String> map1 = new HashMap<>();
        // Fill to less than threshold
        map1.putAll(Countries.capitals(11));
        // Initial capacity 32
        HashMap<String, String> map2 = new HashMap<>(32);
        map2.putAll(map1);
        long t1 = System.currentTimeMillis();
        testGet(map1, 11);
        long t2 = System.currentTimeMillis();
        print("map1 : " + (t1 - t2));
        t1 = System.currentTimeMillis();
        testGet(map2,11);
        t2 = System.currentTimeMillis();
        print("map2 : " + (t1 - t2));
    }
}
