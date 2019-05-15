package strings;

/**
 * @author lh
 * Using the documentation for java.util.regex.Patern
 * as a resource. replace all the vowels in
 * Splitting.knights with underscores
 **/
public class E09_Replacing2 {
    public static void main(String[] args) {
        System.out.println(Splitting.knights.replaceAll("(?i)[aeiou]","_"));
    }
}
