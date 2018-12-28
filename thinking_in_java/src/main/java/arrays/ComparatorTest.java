package arrays;

import java.util.Arrays;
import java.util.Comparator;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-28 15:28
 **/
class CompTypeComparator implements Comparator<CompType> {
	@Override
	public int compare(CompType o1, CompType o2) {
		return Integer.compare(o1.j, o2.j);
	}
}
public class ComparatorTest {
	public static void main(String[] args) {
		CompType[] a = Generated.array(
				new CompType[12], CompType.generator()
		);
		print("before sorting:");
		print(Arrays.toString(a));
		Arrays.sort(a, new CompTypeComparator());
		print("after sorting:");
		print(Arrays.toString(a));
	}
}
