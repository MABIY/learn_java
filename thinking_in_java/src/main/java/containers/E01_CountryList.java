package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static access.util.Print.print;
import static util.Countries.names;

/**
 * @author: liuHua
 * @create: 2019-01-01 17:10
 **/

public class E01_CountryList {
	private static Random rnd = new Random(47);
	
	public static void main(String[] args) {
		List<String> l = new ArrayList<>(names(8));
		Collections.sort(l);
		print("sorted: " + l);
		for (int i = 0; i < 5; i++) {
			Collections.shuffle(l, rnd);
			print("shuffled (" + i + "): " + l);
		}
	}
	
}
