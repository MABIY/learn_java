package strings;

import java.util.Arrays;

/**
 * @author: liuHua
 * @create: 2018-11-21 13:19
 **/

public class Splitting {
	public static String knights =
			"Then, when you have found the shrubbery, you must " +
					"cut down the mightiest tree in the forest... " +
					"with... a herring";
	
	public static void split(String regex) {
		System.out.println(
				Arrays.toString(knights.split(regex))
		);
	}
	
	public static void main(String[] args) {
		split(" "); // Doesn't have a contain regex chars
		split("\\w"); //Non-word characters
		split("n\\W+"); // 'n' followed by non-word characters
	}
}
