package holding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author lh
 * Move the Gerbil class from Exercise 1
 * into a Map, and associate each Gerbil (the value)
 * with it's name as a String (the key)
 * Use an Iterator for the ekySet() to move
 * through the Map, look up the Gerbil for each key,
 * print out the key, and tell the Gerbil to hop()
 **/
public class E17_GerbilMap {
    public static void main(String[] args) {
        Map<String, Gerbil> map = new HashMap<>();
        map.put("Fuzzy", new Gerbil(1));
        map.put("Spot", new Gerbil(2));
        map.put("Joe", new Gerbil(3));
        map.put("Ted", new Gerbil(4));
        Iterator<Map.Entry<String, Gerbil>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Gerbil> entry = it.next();
            System.out.println(entry.getKey() + ": ");
            entry.getValue().hop();
        }
    }
}
