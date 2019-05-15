package strings;

import java.util.Arrays;

/**
 * @author lh
 * Split the string Splitting.knights on the words
 * "the" or "you."
 **/
public class E08_Splitting2 {
    public static void split(String regex) {
        System.out.println(
                Arrays.toString(Splitting.knights.split(regex))
        );
    }

    public static void main(String[] args) {
        split("the|you");
    }
}
