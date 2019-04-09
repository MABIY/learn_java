package operators;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Start with a number that has a binary one in the most significant position
 * (hint: Use a hexadecimal constant). Using the signed right-shift operator,
 * right shift it all way through all of its binary positions each time
 * displaying the result using Integer.toBinaryString().
 **/
public class RightShiftTest {
    public static void main(String[] args) {
        int h = 0x10000000;
        print(Integer.toBinaryString(h));
        for (int i = 0; i < 28; i++) {
            h >>>= 1;
            print(Integer.toBinaryString(h));
        }
    }
}
