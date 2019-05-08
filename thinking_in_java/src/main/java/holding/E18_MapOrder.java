package holding;

import net.mindview.util.Countries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lh
 * Fill a HashMap with key-value pairs. print the results
 * to show ordering by hash code.Extract the pairs,sort by the key,
 * and place the result into a Linkedhashmap.
 * Show that insertion order is maintatined
 **/
public class E18_MapOrder {
    public static void main(String[] args) {
        Map<String, String> m1 = new HashMap<>(Countries.capitals(25));
        System.out.println(m1);
        String[] keys = m1.keySet().toArray(new String[0]);
        Arrays.sort(keys);
        Map<String, String> m2 = new LinkedHashMap<>();
        for (String key : keys) {
            m2.put(key, m1.get(key));
        }
        System.out.println(m2);
    }
}
