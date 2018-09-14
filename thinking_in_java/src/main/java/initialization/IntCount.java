package initialization;

import static org.greggordon.tools.Print.print;

public class IntCount {
    static void count1(int n) {
        for (int i = 0; i < n; i++) {
            print(i + 1);
        }
        System.out.println();
    }

    static void count2(int n) {
        for (int i = 0; i < n; i++) {
            print(i + 1);
            if (i == 99) {
                break;
            }
        }
        System.out.println();
    }

    static void count3(int n) {
        for (int i = 0; i < n; i++) {
            print(i + 1);
            if (i == 99) {
                return;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        count1(100);
        count2(100);
        count3(100);
    }
}
