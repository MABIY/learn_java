package operators;

import static org.greggordon.tools.Print.println;

public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f; // Hexadecimal (lowercase)
        println("i1: " + Integer.toBinaryString(i1));
        int i2 = 0X2f;// Hexadecimal(uppercase)
        println("i2: " + Integer.toBinaryString(i2));

        int i3 = 0177; // Octal (leading zeor)
        println("i3: " + Integer.toBinaryString(i3));

        char c = 0xffff; // max char hex value
        println("c: " + Integer.toBinaryString(c));
        byte b = 0x7f;
        println("b: " + Integer.toBinaryString(b));

        short s = 0x7fff; // max short hex value
        println("s: " + Integer.toBinaryString(s));
        long n1 = 200L; // long suffix
        long n2 = 200l; // long suffix (but can be confusing)
        long n3 = 300;
        float f1 = 1;
        float f2 = 1F; // float suffix
        float f3 = 1f; //float suffix
        double d1 = 1d; // double suffix
        double d2 = 1D; // double suffix
        //(hex and Octal also work with long )

    }
}
