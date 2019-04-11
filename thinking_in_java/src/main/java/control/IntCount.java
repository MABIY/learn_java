package control;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify exercise 1 so that the program exits by using the break keyword at
 * value 99.
 **/
public class IntCount {
    static void Count1(int n) {
        for (int i = 0; i < n; i++) {
            print(i + 1);
        }
    }

    static void Count2(int n) {
        for (int i = 0; i < n; i++) {
            print(i + 1);
            if (i == 99) {
                break;
            }
        }
    }

    static void Count3(int n) {
        for (int i = 0; i < n; i++) {
            print(i + 1);
            if (i == 99) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        Count1(100);
        System.out.println();
        Count2(100);
        System.out.println();
        Count3(100);
    }
}
