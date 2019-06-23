package containers;

import java.util.LinkedHashMap;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * waht you can do with a LinkedHashMap.
 **/
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>(
                new CountingMapData(9)
        );
        print(linkedMap);
        // Least-recently-use order:
        linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.putAll(new CountingMapData(9));
        print(linkedMap);
        for (int i = 0; i < 6; i++) { // Cause accesses:
            linkedMap.get(i);
        }
        print(linkedMap);
        System.out.println(linkedMap.get(0));
        print(linkedMap);
    }
}
