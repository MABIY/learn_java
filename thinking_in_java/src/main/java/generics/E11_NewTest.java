package generics;

import net.lh.util.New;
import net.lh.util.SixTuple;

import java.util.List;
import java.util.Set;

/**
 * @author lh
 * Test New.java by creating your own classes and
 * ensuring that New will work properly with them
 **/
public class E11_NewTest {
    public static void main(String[] args) {
        List<SixTuple<Byte, Short, String, Float, Double, Integer>> list = New.list();
        list.add(new SixTuple<>((byte) 1, (short) 1, "A", 1.0f, 1.0, 1));
        System.out.println(list);
        Set<Sequence<String>> set = New.set();
        set.add(new Sequence<>(5));
        System.out.println(set);
    }
}
