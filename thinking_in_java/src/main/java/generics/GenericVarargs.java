package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lh
 **/
public class GenericVarargs {
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        result.addAll(Arrays.asList(args));
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList("ABCDEFGHIJKLMOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
}
