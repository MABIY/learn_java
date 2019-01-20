package containers;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2019-01-07 21:04
 **/

public class SortedSetDemo {
	public static void main(String[] args) {
		SortedSet<String> sortedSet = new TreeSet<>();
		Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
		print(sortedSet);
		String low = sortedSet.first();
		String high = sortedSet.last();
		print(low);
		print(high);
		Iterator<String> it = sortedSet.iterator();
		for (int i = 0; i <=6; i++) {
			if(i == 3){
				low = it.next();
			}
			if (i == 6) {
				high = it.next();
			} else {
				System.out.println(it.next());
			}
		}
		print(low);
		print(high);
		print(((TreeSet<String>) sortedSet).subSet(low, high));
		print(((TreeSet<String>) sortedSet).headSet(high));
		print(((TreeSet<String>) sortedSet).tailSet(low));
	}
}
