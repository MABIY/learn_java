package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-21 14:27
 **/

public class TestRegularExpression {
	public static void main(String[] args) {
		args = new String[]{"abcabcabcdefabc","abc+","(abc)+","(abc){2,}"};
		if (args.length < 2) {
			print("Usage:\njava TestReqularExpression " +
					"characterSequence regularExpression+");
			System.exit(0);
		}
		print("Input: \"" + args[0] + "\"");
		for (String arg : args) {
			print("Regular expression: \"" + arg + "\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			while (m.find()) {
				print("Match \"" + m.group() + "\" at positions  " +
						m.start() + "-" + (m.end() - 1));
			}
		}
	}
}
