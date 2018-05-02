package arrays;

public class ArrayOfGenericType<T> {
    T[] array; // ok

    @SuppressWarnings("unchekced")
    public ArrayOfGenericType(int size) {
        //array = new T[size]; // Illegal
        array = (T[]) new Object[size];
    }

    //public <U> U[] makerArray() {
        //return new U[10];
    //}
}
