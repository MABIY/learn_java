package control;

import static net.mindview.util.Print.print;
import static org.greggordon.tools.Print.println;

public class IfElseTest{
    static int test(int testval, int begin, int end) {
        if (end < begin) {
            print("end cannot be < begin");
            return 0;
        }

        if ((testval > (begin - 1)) && (testval < (end + 1))) {
            return +1;
        }

        if ((testval < begin) || (testval > end)) {
            return -1;
        }
        print("exceptional case");
        return 13;
    }

    public static void main(String[] args) {
        print(test(10, 5, 4));
        print(test(5, 4, 10));
        print(test(5, 5, 6));
        print(test(10, 5, 7));
        print(test(5, 5, 5));
    }
}
