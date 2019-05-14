package strings;

import java.math.BigInteger;
import java.util.Formatter;
import java.util.Locale;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * For each of the basic conversion types in the
 * above table, Write the most complex formating
 * experssion possible,That is ,use all the possible
 * format specifiers available for that conversion type.
 **/
public class E05_ComplexConversion {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out, Locale.US);
        char u = 'a';
        print("u= 'a'");
        f.format("s: %1$-10s\n", u);
        f.format("c: %1$-10c\n", u);
        f.format("b: %1$-10.10b\n",u);
        f.format("h: %1$-10.10h\n", u);
        int v = 1000;
        print("v = 1000");
        f.format("d 1: %1$(,0+10d\n", v);
        f.format("d 2: %1$-(, 10d\n", v);
        f.format("d 3, v = -v: %1$-(, 10d\n", -v);
        f.format("c, v =121: %1$-10c\n", 121);
        f.format("b: %1$-10.10b\n", v);
        f.format("s: %1$-10.10s\n", v);
        f.format("x: %1$-10x\n", v);
        f.format("h: %1$-10.10h\n", v);
        BigInteger w = new BigInteger("50000000000000");
        print("w = new BigInteger(\"50000000000000\")");
        f.format("d 1: %1$(,0+10d\n",w);
        f.format("d 2: %1$-(, 10d\n", w);
        f.format("d 3, w = -w:%1$-(, 10d\n", w.negate());

        f.format("b: %1$-10.10b\n", w);
        f.format("s: %1$-10.10s\n", w);
        f.format("x 1: %1$(0+10x\n", w);
        f.format("x 2: %1$-( 10x\n", w);
        f.format("x 3, w = -w: %1$-( 10x \n", w.negate());
        f.format("h: %1$-10.10h\n", w);

        Object y = new Object();
        f.format("b: %1$-10.10b\n", y);
        f.format("s: %1$-10.10s\n", y);
        f.format("h: %1$-10.10h\n", y);
        boolean z = false;
        print("z = false");
        f.format("b: %1$-10.10b\n", z);
        f.format("s: %1$-10.10s\n", z);
        f.format("h: %1$-10.10h\n", z);
        // A special no argument conversion type
        f.format("%%: %-10%");
    }
}
