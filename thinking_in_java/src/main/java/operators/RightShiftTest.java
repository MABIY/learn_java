package operators;

import static org.greggordon.tools.Print.println;

public class RightShiftTest {
    public static void main(String[] args) {
        int h = 0x10000000;
        println(Integer.toBinaryString(h));
        for (int i = 0; i < 28; i++) {
            h >>>= 1;
            println(Integer.toBinaryString(h));
        }
    }
}
