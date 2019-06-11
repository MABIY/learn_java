package arrays;

import java.util.Arrays;

/**
 * @author lh
 * Write a method that takes an int argument and
 * returns an array of that size, filled with
 * BerylliumShpere objects.
 **/
public class E02_ReturningArray {
    static BerylliumSphere[] createArray(int size) {
        BerylliumSphere[] a = new BerylliumSphere[size];
        for (int i = 0; i < size; i++) {
            a[i] = new BerylliumSphere();
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createArray(10)));

    }
}
