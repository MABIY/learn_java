package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static access.util.Print.print;
import static access.util.Print.printnb;

/**
 * @author: liuHua
 * @create: 2018-11-22 09:35
 **/

public class Groups {
	static public final String POEM =
			"Twas brillig, and the slithy toves\n" +
					"Did gyre were the borogoves,\n" +
					"All mimsy were the barogoves,\n" +
					"Beware the Jabberwock, my son,\n" +
					"The jaws  bite, the claws that catch.\n" +
					"Beware the jubjub bird, and shunj\n" +
					"The frumious Bandersnatch.";
	
	public static void main(String[] args) {
		Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
		while (m.find()) {
			for (int j = 0; j <= m.groupCount(); j++) {
				printnb("[" + m.group(j) +"]");
			}
			print();
		}
	}
}
