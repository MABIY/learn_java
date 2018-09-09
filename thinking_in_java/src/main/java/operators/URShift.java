package operators;

import static org.greggordon.tools.Print.println;

public class URShift {
    public static void main(String[] args) {
        int i = -1;
        println(Integer.toBinaryString(i));
        i >>>= 10;
        println(Integer.toBinaryString(i));
        long l = -1;
        println(Long.toBinaryString(l));
        l >>>= 10;
        println(Long.toBinaryString(l));
        short s = -1;
        println(Integer.toBinaryString(s));
        s >>>= 10;
        println(Integer.toBinaryString(s));
        byte b = -1;
        println(Integer.toBinaryString(b));
        b >>>= 10;
        println(Integer.toBinaryString(b));
        b = -1;
        println(Integer.toBinaryString(b));
        println(Integer.toBinaryString(b>>>10));
    }
}
