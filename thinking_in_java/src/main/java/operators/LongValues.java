package operators;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Show that hex and octal notations work with long vlaues
 **/
public class LongValues {
    public static void main(String[] args) {
        long n1 = 0xffff; // hexadecimal
        long n2 = 07777; //octal
        print("long n1 in hex = " + Long.toBinaryString(n1));
        print("long n2 in hex = " + Long.toBinaryString(n2));
    }
}
