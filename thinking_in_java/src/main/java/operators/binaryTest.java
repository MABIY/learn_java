package operators;

import static org.greggordon.tools.Print.println;

public class binaryTest {
    public static void main(String[] args) {
        int i = 1 + 4 + 16 + 64;
        int j = 2 + 8 + 32 + 128;
        println("i = " + Integer.toBinaryString(i));
        println("j = " + Integer.toBinaryString(j));
        println("i & j = " + Integer.toBinaryString(i & j));
        println("i | j = " + Integer.toBinaryString(i | j));
        println("i ^ j = " + Integer.toBinaryString(i ^ j));
        println("~i = " + Integer.toBinaryString(~i));
        println("~j = " + Integer.toBinaryString(~j));
    }
}
