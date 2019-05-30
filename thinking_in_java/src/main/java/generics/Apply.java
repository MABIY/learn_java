package generics;

import java.lang.reflect.Method;

/**
 * @author lh
 **/
public class Apply {
    public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
        // lhtd
    }
}
