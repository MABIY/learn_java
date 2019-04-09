package operators;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Write a method that displays char values in binary form. Demonstrate it
 * using serveral different characters
 **/
public class CharBinaryTest {
    public static void main(String[] args) {
        char c = 'a';
        print(Integer.toBinaryString(c));
        c = 'b';
        print(Integer.toBinaryString(c));
        c = 'c';
        print(Integer.toBinaryString(c));
        c = 'd';
        print(Integer.toBinaryString(c));
        c += 1;
        print(Integer.toBinaryString(c));
        c = 'A';
        print(Integer.toBinaryString(c));
        for (int i = 0; i < 25; i++) {
            c += 1;
            System.out.println(c);
            print(Integer.toBinaryString(c));
        }
    }
}
