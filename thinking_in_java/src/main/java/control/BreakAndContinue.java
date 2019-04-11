package control;

import static net.mindview.util.Range.range;

/**
 * @author lh
 * Demonstrates break and continue keywords
 **/
public class BreakAndContinue {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //out of for loop
            if (i == 74) {
                break;
            }
            //Next iteration
            if (i % 9 != 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
        // Using foreach
        for (int i : range(100)) {
            // Out of for loop
            if (i == 74) {
                break;
            }
            // Next iteration
            if (i % 9 != 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
        int i = 0;
        // An "infinite loop"
        while (true) {
            i++;
            int j = i * 27;
            if (j == 1269) {
                break; // Out of loop
            }
            // Top of loop
            if (i % 10 != 0) {
                continue;
            }
            System.out.print(i + " ");
        }
    }
}
