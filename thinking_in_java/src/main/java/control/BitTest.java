package control;

import static org.greggordon.tools.Print.println;

public class BitTest {
    static void binaryPrint(int q) {
        if (q == 0) {
            System.out.println(0);
        } else {
            int nlz = Integer.numberOfLeadingZeros(q);
            q <<= nlz;
            for (int p = 0; p < 32 - nlz; p++) {
                int n = (Integer.numberOfLeadingZeros(q) == 0) ? 1 : 0;
                System.out.print(n);
                q <<= 1;
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int i = 1 + 4 + 16 + 64;
        int j = 2 + 8 + 32 + 128;
        int k = 0x100;
        int m = 0;
        println("Using Integer.toBinaryString():");
        println("i = " + Integer.toBinaryString(i));
        println("j = " + Integer.toBinaryString(j));
        println("k = " + Integer.toBinaryString(k));
        println("m = " + Integer.toBinaryString(m));
        println("i & j = " + (i & j) + " = " + Integer.toBinaryString(i & j));
        println("i | j = " + (i | j) + " = " + Integer.toBinaryString(i | j));
        println("i ^ j = " + (i ^ j) + " = " + Integer.toBinaryString(i ^ j));
        println("~i = " + Integer.toBinaryString(~i));
        println("~j = " + Integer.toBinaryString(~j));
        println("Using binaryPrint():");
        println("i = " + i + " = ");
        binaryPrint(i);
        println("j = " + j + " = ");
        binaryPrint(j);
        println("k = " + k + " = ");
        binaryPrint(k);
        println("m = " + m + " = ");
        binaryPrint(m);
        println("i & j = " + (i & j) + " = ");
        binaryPrint(i & j);
        println("i | j = " + (i | j) + " = ");
        binaryPrint(i | j);
        println("i ^ j = " + (i ^j)  + " = ");
        binaryPrint(i ^ j);
        println("~i = " + ~i + " = ");
        binaryPrint(~i);
        println("~i = " + ~i + " = ");
        binaryPrint(~i);
        println("~j = " + ~j + " = ");
        binaryPrint(~j);
    }
}
