package operators;

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Demonstrates the matchematical operators
 **/
public class MathOps {
    public static void main(String[] args) {
        //Create a seeded random number generator:
        Random rand = new Random(47);
        // Choose value from 1 to 100
        int i, j, k;
        j = rand.nextInt(100) + 1;
        print("j : " + j);
        k = rand.nextInt(100) + 1;
        print("k: " + k);
        i = j + k;
        print("j + k: " + i);
        i = j - k;
        print("j - k : " + i);
        i = k / j;
        print("k / j : " + i);
        i = k * j;
        print("k * j : " + i);
        i = k % j;
        print("K % j : " + i);
        j %= k;
        print("j %= K : " + j);
        // Floating-point number tests:
        float u ,v ,w; // Applies to doubles, too
        v = rand.nextFloat();
        print("v : " + v);
        w = rand.nextFloat();
        print("w : " + w);
        u = v + w;
        print("v + w : " + u);
        u = v - w;
        print("v - w : " + u);
        u = v * w;
        print("v * w : " + u);
        u = v / w;
        print("v / w : " + u);
        // The following also works for char,
        // byte, short, int , long ,and double:
        u += v;
        print("u += v : " + u);
        u -= v;
        print("u -= v : " + u);
        u *= v;
        print("u *= v : " + u);
        u /= v;
        print("u /= v: " + u);

    }
}
