package operators;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Start with a number that is all binary ones. Left shift it ,then use the
 * unsigned right-shift operator to right shift throught all of its binary
 * positions,each time displaying the result using Integer.toBinaryString()
 **/
public class RightShiftTest2 {
    public static void main(String[] args) {
        int h = -1;
        print(Integer.toBinaryString(h));
        h <<= 10;
        print(Integer.toBinaryString(h));
        for (int i = 0; i < 32; i++) {
            h >>>= 1;
            print(Integer.toBinaryString(h));
        }
    }
}
