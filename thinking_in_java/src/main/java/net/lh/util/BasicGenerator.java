package net.lh.util;

/**
 * @author lh
 * Automatically create a Generator. Given a class
 * with a defualt (no-arg) constructor
 **/
public class BasicGenerator<T> implements Generator<T>{
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }



    @Override
    public T next() {
            // Assume type is a public class:
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }
}
