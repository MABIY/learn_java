package arrays;

/**
 * @author lh
 * Arrays of generic types won't compile.
 **/
public class ArrayOfGenericType<T> {
    T[] array;  // ok

    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
        // array = new T[size]; // Illegal
        array = (T[]) new Object[size]; // "unchekce" waring
    }

    public static void main(String[] args) {
        new ArrayOfGenericType<>(1);
    }
    // public <U> U[] makeArray() {
        // return new U[10];
    // }
}
