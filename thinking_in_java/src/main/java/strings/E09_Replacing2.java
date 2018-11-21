package strings;

/**
 * @author: liuHua
 * @create: 2018-11-21 13:58
 * Using the documentation for java.util.regex.Pattern
 * as a resource,replace all the vowels in
 * Splitting.knights with underscores
 **/

public class E09_Replacing2 {
	public static void main(String[] args) {
		System.out.println(Splitting.knights.replaceAll(
				"(?i)[aeiou]","_"
		));
	}
}
