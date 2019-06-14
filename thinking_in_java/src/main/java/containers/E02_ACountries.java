package containers;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static net.lh.util.Countries.capitals;
import static net.lh.util.Countries.names;

/**
 * @author lh
 * Produce a Map and a Set containing all the
 * countries and that begin with 'A'.
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
        Map<String, String> aMpa = map.headMap(b);
        Set<String> aSet = set.headSet(b);
        System.out.println("aMap = " + aMpa);
        System.out.println("aSet = " + aSet);
    }
}
