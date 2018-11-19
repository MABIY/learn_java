package strings;

import static net.mindview.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-18 19:38
 **/

public class Immutable {
	public static String upcase(String s) {
		return s.toUpperCase();
	}
	
	public static void main(String[] args) {
		String q = "howdy";
		print(q); // howdy
		String qq = upcase(q);
		print(qq); // HOWDY
		print(q); // howdy
		String s = "asdf";
		String x = Immutable.upcase(s);
		System.out.println(x);
		System.out.println(s);
		
	}
}
