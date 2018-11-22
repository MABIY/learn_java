package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-22 10:20
 **/

public class StartEnd {
	public static String input =
			"As long as there is injustice, whenever a\n" +
					"Targathian baby cries out, wherever a distress\n" +
					"signal sounds among the stars ... We'll be there.\n" +
					"This fine ship. and this fine crew ...\n" +
					"Never give up! Never surrender!";
	
	static void examine(String s, String regex) {
		Display d = new Display(regex);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		while (m.find()) {
			d.display("find() '" + m.group() +
					"' start = " + m.start() + " end= " + m.end());
		}
		if (m.lookingAt()) {  // No reset() necessary
			d.display("lookingAt() "+m.group() +" 'start = '"
					+ m.start() + " end= " + m.end());
		}
		
		if (m.matches()) {
			d.display("matches()"+m.group()+"' start = " + m.start() + " end = " + m.end());
		}
		
	}
	
	public static void main(String[] args) {
		for (String in :
				input.split("\n")) {
			for (String regex : new String[]{"\\w*ere\\w*",
					"\\w*ever", "T\\w+", "Never.*?!"}) {
				examine(in, regex);
			}
		}
	}
	
	private static class Display {
		private boolean regexPrinted;
		private String regex;
		
		public Display(String regex) {
			this.regex = regex;
		}
		
		void display(String message) {
			if (!regexPrinted) {
				print(regex);
			}
			print(message);
		}
	}
}
