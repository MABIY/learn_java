package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 **/
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit());
        List<? super Apple> a = new ArrayList<>();
    }
}
