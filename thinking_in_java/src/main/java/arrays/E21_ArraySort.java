package arrays;

import net.mindview.util.Generated;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

class ComparableBerylliumSphere extends BerylliumSphere implements Comparable<BerylliumSphere> {

    // BerylliumSphere.id is private , so we need to use
    // reflection to get its value.
    static long getID(BerylliumSphere bs) {
        try {
            Field fid = BerylliumSphere.class.getDeclaredField("id");
            fid.setAccessible(true);
            return fid.getLong(bs);
        } catch (Exception e) {
           e.printStackTrace();
            return 0L; //Bogus value
        }
    }


    @Override
    public int compareTo(BerylliumSphere o) {
        long id = getID(this);
        long rvid = getID(o);
        return (Long.compare(id,rvid));

    }
}
public class E21_ArraySort {
    public static void main(String[] args) {
        Random r = new Random(7);
        BerylliumSphere[] a = Generated.array(BerylliumSphere.class, new BSGenerator(), 5);
        Collections.shuffle(Arrays.asList(a),r);
        System.out.println("Before sort 1: a = " +Arrays.toString(a) );
        try {
            Arrays.sort(a);
            System.out.println("After sort 1: a = " + Arrays.toString(a));
        } catch (ClassCastException e) {
            System.out.println("Array cannot be sorterd!");
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = new ComparableBerylliumSphere();
        }
        Collections.shuffle(Arrays.asList(a),r);
        System.out.println("Before sort 2: a = " +Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("After sort 2: a= " +Arrays.toString(a));
        Collections.shuffle(Arrays.asList(a),r);
        System.out.println("Before rev,sort 3: a = " + Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println("After rev. sort 3: a = " +Arrays.toString(a));
    }
}
