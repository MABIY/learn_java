package arrays;

import net.lh.util.Generated;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Try to sort an array of the objects in Exercise 18.
 * Implement Comparable to fix teh problem. Now
 * Create a Comparator to sort the objects into reverse
 * order.
 **/
class ComparableBerylliumSphere extends BerylliumSphere implements Comparable<BerylliumSphere> {
    // BerylliumSphere.id is priviate, so we need to use
    // reflection to get its vlaue.
    static long getID(BerylliumSphere bs) {
        try {
            Field fid = BerylliumSphere.class.getDeclaredField("id");
            fid.setAccessible(true);
            return fid.getLong(bs);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L; // Bogus value
        }
    }

    @Override
    public int compareTo(BerylliumSphere o) {
        long id = getID(this);
        long rvid = getID(o);
        return Long.compare(id, rvid);
    }
}

public class E21_ArraySort {
    public static void main(String[] args) {
        Random r = new Random(47);
        BerylliumSphere[] a = Generated.array(
                BerylliumSphere.class, new BSGenerator(), 5
        );
        Collections.shuffle(Arrays.asList(a), r);
        print("Before sort1: a = " + Arrays.toString(a));
        try {
            Arrays.sort(a);
            print("After sort 1: a = " + Arrays.toString(a));
        } catch (ClassCastException e) {
            System.out.println("Array cannot be sorted!");
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = new ComparableBerylliumSphere();
        }
        Collections.shuffle(Arrays.asList(a), r);
        print("Before sort 2: a = " + Arrays.toString(a));
        Arrays.sort(a);
        print("After sort 2: a = " + Arrays.toString(a));
        Collections.shuffle(Arrays.asList(a), r);
        print("before rev,sort 3: a = " + Arrays.toString(a));
        Arrays.sort(a, Collections.reverseOrder());
        print("After rev. sort 3: a = " + Arrays.toString(a));
    }
}
