package base.concept.test;

import com.china.lh.annotation.ExtractInterface;

/**
 * @author lh
 * APT-based annotation processing
 */
@ExtractInterface("IMultiplier")
public class Multiplier {
    public static void main(String[] args) {
        Multiplier m = new Multiplier();
        System.out.println("11*16 = " + m.multiply(11, 16));
    }

    public int multiply(int x, int y) {
        int total = 0;
        for (int i = 0; i < x; i++) {
            total = add(total, y);
        }
        return total;
    }

    private int add(int x, int y) {
        return x + y;
    }

}
