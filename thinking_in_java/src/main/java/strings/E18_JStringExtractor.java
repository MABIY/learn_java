package strings;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: liuHua
 * @create: 2018-11-22 15:26
 * Write a program that reads a Java source-code file
 * and display all the string literal in the code
 * (provide the file name on the command line).
 **/

public class E18_JStringExtractor {
	static final String STR_EXT_REGEX =
			"\"(?:[^\"\\\\\\n\\r]|(?:\\\\(?:[untbrf\\\\'\"]" +
					"|[0-9A-Fa-f]{4}|[0-7]{1,2}|[0-3][0-7]{2})))*\"";
	
	public static void main(String[] args) {
		args = new String[]{"thinking_in_java/src/main/java/strings/E18_JStringExtractor.java"};
		if (args.length < 1) {
			System.out.println(
					"Usage: java E18_JStringExtractor file"
			);
			System.exit(0);
		}
		
		String src = TextFile.read(args[0]);
		Pattern p = Pattern.compile(STR_EXT_REGEX);
		Matcher m = p.matcher(src);
		while (m.find()) {
			System.out.println(m.group().substring(1, m.group().length() - 1));
		}
		
		// "This is NOT a String but a comment!
		String dummy = "\u003F\u003f\n\060\607";
	}
}
