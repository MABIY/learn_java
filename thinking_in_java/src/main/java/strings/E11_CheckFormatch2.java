package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lh
 * Apply the regular experssion
 * (?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b
 * to
 * "Arline ate eight apples and one orange while Anita hadn't any"
 **/
public class E11_CheckFormatch2 {
    public static  Pattern p = Pattern.compile(
            "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b"
    );
    public static void main(String[] args) {
        Matcher m = p.matcher("Arline ate eight apples and " +
                "one orange while Anita hadn't any");
        while (m.find()) {
            System.out.println("Match \"" + m.group()+"\" at positions " + m.start() + "-"+ (m.end() -1));
        }
    }
}
