package operators;

import static org.greggordon.tools.Print.println;

public class RightShiftTest2 {
    public static void main(String[] args) {
        int h = -1;
        println(Integer.toBinaryString(h));
        h <<= 10;
        println(Integer.toBinaryString(h));
        for (int i = 0; i < 32; i++) {
            h >>>= 1;
            println(Integer.toBinaryString(h));

        }
    }
}
