package control;

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify exercise 2 with infinte while loop.Stop program with Ctrl-c
 **/
public class CompareIntsForever {
    public static void main(String[] args) {
        Random rand1 = new Random();
        Random rand2 = new Random();
        for (int i = 0; i < 25; i++) {
            int x = rand1.nextInt();
            int y = rand2.nextInt();
            if (x < y) {
                print(x + " < " + y);
            } else if (x > y) {
                print(x + " > " + y);
            } else {
                print(x + " = " + y);
            }
        }
        Random rand3 = new Random();
        Random rand4 = new Random();
        while (true) {
            for (int i = 0; i < 25; i++) {
                int x = rand3.nextInt(10);
                int y = rand4.nextInt(10);
                if (x < y) {
                    print(x + " < " + y);
                } else if (x > y) {
                    print(x + " > " + y);
                } else {
                    print(x + " = " + y);
                }
            }
        }
    }
}
