package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-11-18 20:31
 **/

public class InfiniteRecursion {
	@Override
	public String toString() {
		return " InfiniteRecursion address: " + this + "\n";
	}
	
	public static void main(String[] args) {
		List<InfiniteRecursion> v = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);
	}
}
