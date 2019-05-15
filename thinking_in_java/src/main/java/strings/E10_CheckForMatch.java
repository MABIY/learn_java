package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lh
 * For the phrase "Java now has regular expressions"
 * evaluate whether teh following expressions will find a
 * match:
 * ^Java
 * \Breg.*
 * s?
 * s*
 * s+
 * s{4}
 * s{1}
 * s{0,3}
 **/
public class E10_CheckForMatch {
    public static void main(String[] args) {
        String source = "Java now has regular expressions";
        String[] regEx = {"^Java", "\\Breg.*",
                "n.w\\s+h(a|i)s", "s?", "s*", "s+", "s{4}", "s{1}", "s{0,3}"};
        System.out.println("Source string: " + source);
        for (String pattern : regEx) {
            System.out.println("Reqular expression: \"" + pattern + "\"");
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(source);
            while (m.find()) {
                System.out.println("Match \"" + m.group() + "\" at positons " + m.start() + "-" + (m.end() - 1));
            }
        }
    }
}
