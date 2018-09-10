package control;

import static net.mindview.util.Print.print;

public class IntCount {
    static void count1(int n) {
        for (int i = 0; i < n; i++) {
            print(i + 1);
        }
    }

    static void count2(int n) {
        for (int i = 0; i < n; i++) {
            print(i + 1);
            if (i == 99) {
                break;
            }
        }
    }
    static void count3(int n) {
        for (int i = 0; i < n; i++) {
            print(i + 1);
            if (i == 99) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        count1(100);
        count2(100);
        count3(100);
    }
}
