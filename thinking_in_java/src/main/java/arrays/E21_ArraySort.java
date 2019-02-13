package arrays;



import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-28 15:33
 **/
class ComparableBerylliumSphere extends BerylliumSphere implements Comparable<BerylliumSphere> {
	// BerylliumSphere.id is private, so we need to use
	// reflection to get its value.
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
	public int compareTo(BerylliumSphere rv) {
		long id = getID(this);
		long rvid = getID(rv);
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
		print("Before sort 1: a = " + Arrays.toString(a));
		try {
			Arrays.sort(a);
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
		print("Before rev,sort 3: a = " + Arrays.toString(a));
	}
}