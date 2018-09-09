package operators;

import static org.greggordon.tools.Print.println;

public class LongValues {
    public static void main(String[] args) {
        long n1 = 0xfff; // hexadecimal
        long n2 = 077777; // octal
        println("long n1 in hex = " + Long.toBinaryString(n1));
        println("long n2 in hex = " + Long.toBinaryString(n2));
    }
}
