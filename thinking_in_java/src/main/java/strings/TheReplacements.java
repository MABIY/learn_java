package strings;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-22 13:14
 **/
/*! Here's a block of text to use as input to
	the regular expression matcher.Note that we'll
	first extract the block of text of looking for
	the special delimiters. then process the
	extracted block. !*/

public class TheReplacements {
	public static void main(String[] args) {
		String s = TextFile.read("/home/lh/project/learn_java/thinking_in_java/src/main/java/strings/TheReplacements.java");
		// Match the specially commented block of text above:
		Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
		if (mInput.find()) {
			s = mInput.group(1); // Captured by parentheses
		}
		//Replace two or more space with a single space:
		s = s.replaceAll(" {2,}", " ");
		//Replace one or more spaces at the beginning of each
		// line with no spaces. mUst enable MuLTiLINE mode:
		s = s.replaceAll("(?m)^ +", "");
		print(s);
		s = s.replaceFirst("[aeiou]", "[VOWELl]");
		StringBuffer sbuf = new StringBuffer();
		Pattern p = Pattern.compile("[aeiou]");
		Matcher m = p.matcher(s);
		// process the find information as you
		// perform the replacements
		while (m.find()) {
			m.appendReplacement(sbuf, m.group().toUpperCase());
		}
		//Put in the remainder of the text
		m.appendTail(sbuf);
		print(sbuf);
	}
}
