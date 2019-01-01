package containers;

import java.util.LinkedHashSet;
import java.util.Set;

import static util.Countries.names;

/**
 * @author: liuHua
 * @create: 2019-01-01 17:19
 **/

public class E03_VerifySet {
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();
		for (int i = 0; i < 5; i++) {
			set.addAll(names(10));
		}
		System.out.println(set);
	}
}
