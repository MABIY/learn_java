package arrays;

import java.util.Arrays;
import java.util.Comparator;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * @author: liuHua
 * @create: 2018-12-28 16:43
 **/

public class E24_ArraySearch {
	public static void main(String[] args) {
		Comparator<DataHolder> comp = new Comparator<DataHolder>() {
			@Override
			public int compare(DataHolder o1, DataHolder o2) {
				return Integer.compare(o1.data, o2.data);
			}
		};
		
		DataHolder[] a = new DataHolder[10];
		for (int i = 0; i < a.length; i++) {
			a[i] = new DataHolderWithEquals(i);
		}
		
		Arrays.sort(a, comp);
		
		int location = Arrays.binarySearch(a, a[7], comp);
		printnb("Location of " + a[7] + " is " + location);
		if (location >= 0) {
			print(", a[" + location + "] = " + a[location]);
		} else {
			print();
		}
		location = Arrays.binarySearch(a, a[5], comp);
		printnb("Location of " + a[5] + " is " + location);
		if (location >= 0) {
			print(", a[" + location + "] = " + a[location]);
		}
	}
}
