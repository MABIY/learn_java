package strings;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-21 13:38
 **/

public class Replacing {
	static String s = Splitting.knights;
	
	public static void main(String[] args) {
		print(s.replaceFirst("f\\w+", "located"));
		print(s.replaceAll("shrubbery|tree|herring","banana"));
	}
}
