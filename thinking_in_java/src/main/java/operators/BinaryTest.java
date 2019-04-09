package operators;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Write a program with two constant values, one with alternating binary ones and
 * zeroes, with a zero in the least-significant digit,and the second,also
 * alternating,with a one in the least-significant digit (hint: It's easiest to use
 * hexadecimal constants for this). Take these two values and combine them in
 * all possible ways using the bitwise operators, and display the results using
 * Integer.toBinaryString()
 *
 **/
public class BinaryTest {
    public static void main(String[] args) {
        int i = 1 + 4 + 16 + 64;
        int j = 2 + 8 + 32 + 128;
        print("i = " + Integer.toBinaryString(i));
        print("j = " + Integer.toBinaryString(j));
        print("i & j = " + Integer.toBinaryString(i & j));
        print("i | j = " + Integer.toBinaryString(i | j));
        print("i ^ j = " + Integer.toBinaryString(i ^ j));
        print("~i = " + Integer.toBinaryString(~i));
        print("~j = " + Integer.toBinaryString(~j));
    }
}
