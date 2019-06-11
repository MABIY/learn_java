package arrays;

import typeinfo.interfacea.A;

/**
 * @author lh
 * "Erasure gets in the way again-this example
 * attempts to create arrays of types that have bee
 * erased, and are thus unkown types". Notice that
 * you can create an array of Object, and cast it ,
 * but you get an "unchekced" warning at compile
 * time because the array doesn't  really hold or
 * dynamically check for type T. That is , if I create
 * a String[],java will enforce at both compile time
 * and run time that I can only place String objects
 * in that array, however ,if I create an Object[],
 * I can put anything except primitive types in that array.
 **/

class A8{}
public class E08_LeftToReader<T> {
    @SuppressWarnings("unchecked")
    T[] a = (T[]) new Object[2]; // compile warning: unchecked cast

    public static void main(String[] args) {
        String[] sa = new String[2];
        // sa[0] = new Integer(0); // error: incompatible types
        Object[] oa = new Object[3];
        oa[0] = new String("hi");
        oa[1] = new A8();  // arbitrary object ok
        int x = 2;
        oa[2] = x; // Autoboxing converts int to Integer:
        System.out.println("oa[2]: " + oa[2].getClass());
        oa = sa;
        System.out.println("oa: " + oa.getClass());
        // compiles , but runtime ArrayStoreException.
        oa[0] = 3;
    }
}
