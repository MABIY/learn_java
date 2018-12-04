package generics;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;

/**
 * @author: liuHua
 * @create: 2018-12-04 15:19
 * Use RandomList with two more types in addition
 * to the one shown in main()
 **/

public class E06_RandomListTest {
	private static void dump(RandomList<?> rl) {
		for (int i = 0; i < 11; i++) {
			System.out.print(rl.select() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		RandomList<String> rs = new RandomList<>();
		for (String s : ("The quick brown fox jumped over " +
				"the lazy brown dog").split(" ")) {
			rs.add(s);
		}
		dump(rs);
		RandomList<Integer> ri = new RandomList<>();
		Generator<Integer> gi = new CountingGenerator.Integer();
		
		for (int i = 0; i < 11; i++) {
			ri.add(gi.next());
		}
		dump(ri);
		RandomList<Character> rc = new RandomList<>();
		Generator<Character> gc = new CountingGenerator.Character();
		for (int i = 0; i < 11; i++) {
			rc.add(gc.next());
		}
		dump(rc);
	}
}
