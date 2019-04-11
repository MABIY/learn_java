package control;

/**
 * @author lh
 * Demonstrates "for" loop by listing
 * all the lowercase ASCII letters.
 **/
public class ListCharacters {
    public static void main(String[] args) {
        for (char i = 0; i < 128; i++) {
            if (Character.isLowerCase(i)) {
                System.out.println("value: " + (int)i +
                        " character: " + i);
            }
        }
    }
}
