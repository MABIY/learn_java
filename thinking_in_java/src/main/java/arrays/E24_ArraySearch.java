package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class E24_ArraySearch {
    public static void main(String[] args) {
        Comparator<DataHolder> comp = new Comparator<DataHolder>() {
            @Override
            public int compare(DataHolder o1, DataHolder o2) {
                return (Integer.compare(o1.data, o2.data));
            }
        };
        DataHolder[] a = new DataHolder[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = new DataHolderWithEquals(i);
        }
        Arrays.sort(a, comp);
        int location = Arrays.binarySearch(a, a[7]);
        System.out.println("Location of " + a[7] + " is " + location);
        if (location >= 0) {
            System.out.println(", a[" + location + "] = " + a[location]);
        } else {
            System.out.println();
        }
        location = Arrays.binarySearch(a, a[5], comp);
        System.out.println("Location of " + a[5] + " is " + location);
        if (location >= 0) {
            System.out.println("a, a[" + location + "] = " + a[location]);
        }
    }
}
