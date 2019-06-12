package net.lh.util;


import java.lang.reflect.Array;

/**
 * @author lh
 **/
public class Generated {
    // Fill an existing array:
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<>(gen, a.length).toArray(a);
    }

    // Create a new array
    @SuppressWarnings("unchekced")
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[]) Array.newInstance(type, size);
        return new CollectionData<>(gen, size).toArray(a);
    }
}
