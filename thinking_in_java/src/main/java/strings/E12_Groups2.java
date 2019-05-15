package strings;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify Groups.java to count all unique words
 * with no initial capital letter.
 **/
public class E12_Groups2 {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        Matcher m = Pattern.compile("\\b((?![A-Z])\\w+)\\b").matcher(Groups.POEM);

        while (m.find()) {
            words.add(m.group(1));
        }
        print("Number of unique words = " + words.size());
        print(words.toString());

    }
}
