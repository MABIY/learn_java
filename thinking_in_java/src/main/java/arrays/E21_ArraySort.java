package arrays;

import java.lang.reflect.Field;
import java.util.Comparator;

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
        return 0;
    }
}
public class E21_ArraySort {
}
