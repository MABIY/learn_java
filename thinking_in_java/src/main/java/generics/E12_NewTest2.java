package generics;

import net.lh.util.New;
import net.lh.util.SixTuple;

import java.util.List;
import java.util.Set;

/**
 * @author lh
 * Repeat the previous exercise using explicit type
 * specification
 **/
public class E12_NewTest2 {
    static void f(List<SixTuple<Byte, Short, String, Float, Double, Integer>> l) {
        l.add(new SixTuple<>((byte) 1, (short) 1, "A", 1.0F, 1.0, 1));
        System.out.println(l);
    }

    static void g(Set<Sequence<String>> s) {
        s.add(new Sequence<>(5));
        System.out.println(s);
    }

    public static void main(String[] args) {
        f(New.<SixTuple<Byte, Short, String, Float, Double, Integer>>list());
        g(New.<Sequence<String>>set());
    }
}
