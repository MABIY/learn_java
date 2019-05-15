package strings;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.lh.util.Print.print;

/*! Here's a block of text to use as input to
    the regular expression matcher. Nothe that we'll
    first extract the block of text by looking for
    the special delimiters, then process the
    extracied block. !*/
public class TheReplacements {
    public static void main(String[] args) {
        String s = TextFile.read("thinking_in_java/src/main/java/strings/TheReplacements.java");
        // Match the specially commented block of text above:
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);
        if (mInput.find()) {
            s = mInput.group(1);// Captured by parentheses
        }
        // Replace two or more spaces with a single space:
        s = s.replaceAll(" {2,}"," ");
        // Replace one or more spaces at the beginning of each
        // line with no spaces, Must enable MULTILINE mode:
        s= s.replaceAll("(?m)^ +","");
        print(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        // Process the find information as you
        // perform the replacements:
        while (m.find()) {
            m.appendReplacement(sbuf, m.group().toUpperCase());
        }
        // PUt in the remainder of the text:
        m.appendTail(sbuf);
        print(sbuf);
    }
}
