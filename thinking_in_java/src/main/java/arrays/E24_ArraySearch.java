package arrays;

import java.util.Arrays;
import java.util.Comparator;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Show that the class from Exercise 19 can be searched
 **/
public class E24_ArraySearch {
    public static void main(String[] args) {
        Comparator<DataHolder> comp = new Comparator<DataHolder>() {
            @Override
            public int compare(DataHolder o1, DataHolder o2) {
                return (Integer.compare(o1.data, o2.data));
            }
        };
        DataHolder[] a = new DataHolderWithEquals[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = new DataHolderWithEquals(i);
        }
        Arrays.sort(a, comp);
        int location = Arrays.binarySearch(a, a[7], comp);
        print("Location of " + a[7] + " is " + location);
        if (location >= 0) {
            print(", a[" + location + "] = " + a[location]);
        } else {
            print();
        }
        location = Arrays.binarySearch(a, a[5], comp);
        print("Location of " + a[5] + " is " + location);
        if (location >= 0) {
            print(", a[" + location + "] = " + a[location]);
        }
    }


}
