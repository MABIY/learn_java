package control;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * For loops with labeled break' and "labeled continue."
 **/
public class LabeledFor {
    public static void main(String[] args) {
        int i = 0;
        // Can't have statements here
        outer:
        // infinite loop
        for (; true; ) {
            System.out.println("inner");
            inner: // Can't have statements here
            for (; i < 10; i++) {
                print("i = " + i);
                if (i == 2) {
                    print("continue");
                    continue;
                }
                if (i == 3) {
                    print("break");
                    i++; // Otherwise i never
                    // gets incremented.
                    break;
                }
                if (i == 7) {
                    print("continue outer");
                    i++; // OtherWise i never
                    // gets incremented
                    continue outer;
                }
                if (i == 8) {
                    print("break outer");
                    break outer;
                }
                for (int j = 0; j < 5; j++) {
                    if (j == 3) {
                        print("continue inner");
                        continue inner;
                    }

                }
            }
            System.out.println("fdsfds1");
        }
        System.out.println("rewrew");
    }
}

