package interfaces;

import java.util.Random;

/**
 * @author lh
 **/
public class RandomChars {
    private static int a = 0;

    private static Random rand = new Random();

    public char next() {
        return (char)a++;
    }

    public static void main(String[] args) {
        RandomChars rc = new RandomChars();
        for (int i = 0; i < 128; i++) {
            System.out.println(rc.next() + " ");
        }
    }
}
