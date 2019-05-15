package strings;

/**
 * @author lh
 * Using the documentation for java.util.regex.Pattern
 * as a resource. write and test a regular expression
 * that checs a sentence to see that it begins with a
 * capital letter and ends with a period.
 **/
public class E07_SentenceChecker {
    public static boolean matches(String text) {
        return text.matches("\\p{javaUpperCase}.*\\.");
    }

    public static void main(String[] args) {
        System.out.println(matches("This is correct."));
        System.out.println(matches("bad sentence 1."));
        System.out.println(matches("This is also correct..."));
    }
}
