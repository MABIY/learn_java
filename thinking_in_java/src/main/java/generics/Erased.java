package generics;

import java.lang.reflect.Array;

/**
 * @author lh
 * {CompileTimeError} (Won't compile)
 **/
public class Erased<T> {
    private  final int SIZE = 100;

    public  void f(Object arg) {
        // if(arg instanceof T){} //Error
        // T var = new T(); // Error
        // T[] array = new T[SIZE]; // Error
        T[] array = (T[]) new Object[SIZE];
    }

    public static void main(String[] args) {
        Erased<String> stringErased = new Erased<>();
        stringErased.f("te");
    }
}