package arrays;

import net.lh.util.Generated;
import net.lh.util.Generator;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author lh
 * Create and test a Generator  for BigDecimal, and
 * ensure that it works with the Generated methods
 **/
class BigDeciamlGenerator implements Generator<BigDecimal>{
    private BigDecimal value = new BigDecimal(0);
    private BigDecimal step;

    public BigDeciamlGenerator(BigDecimal step) {
        this.step = step;
    }

    @Override
    public BigDecimal next() {
        BigDecimal oldValue = value;
        value = value.add(step);
        return oldValue;
    }
}
public class E17_BigDecimalGenerator {
    public static void main(String[] args) {
        BigDecimal[] a = {
                new BigDecimal(9), new BigDecimal(8),
                new BigDecimal(7), new BigDecimal(6)
        };
        System.out.println(Arrays.toString(a));
        a = Generated.array(a, new BigDeciamlGenerator(new BigDecimal("0.1")));
    }
}
