package holding;

import java.util.ArrayList;

/**
 * @author lh
 * Simple container example (produces compiler warnings)
 **/
class Apple{
    private static long counter;
    private final long id = counter++;
    public long id() {
        return id;
    }
}
class Orange{

}
@SuppressWarnings("unchecked")
public class ApplesAndOrangesWithoutGenerics {
    // public static void main(String[] args) {
    //     ArrayList apples = new ArrayList();
    //     for (int i = 0; i < 3; i++) {
    //         apples.add(new Apple());
    //     }
    //     // Not prevented from adding an Orange to apples
    //     apples.add(new Orange());
    //     for (int i = 0; i < apples.size(); i++) {
    //         ((Apple) apples.get(i)).id();
    //         // Orange is detected only at run time
    //     }
    // }
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            apples.add(new Apple());
        }
        // Compile-time error:
        // apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++) {
            System.out.println(apples.get(i).id());
        }
        // Using foreach
        for (Apple c : apples) {
            System.out.println(c.id());
        }
    }
}
