package operators;

import static org.greggordon.tools.Print.println;

public class CharBinaryTest {
    public static void main(String[] args) {
        char c = 'a';
        println(Integer.toBinaryString(c));
        c = 'b';
        println(Integer.toBinaryString(c));
        c = 'c';
        println(Integer.toBinaryString(c));
        c = 'd';
        println(Integer.toBinaryString(c));
        c += 1;
        println(Integer.toBinaryString(c));
        c = 'A';
        println(Integer.toBinaryString(c));
        for (int i = 0; i < 26; i++) {
            c += 1;
            println(Integer.toBinaryString(c));
        }
    }
}
