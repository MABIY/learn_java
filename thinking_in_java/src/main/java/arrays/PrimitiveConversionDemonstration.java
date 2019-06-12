package arrays;

import net.lh.util.ConvertTo;
import net.lh.util.CountingGenerator;
import net.lh.util.Generated;

import java.util.Arrays;

/**
 * @author lh
 **/
public class PrimitiveConversionDemonstration {
    public static void main(String[] args) {
        Integer[] a = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
        int[] b = ConvertTo.primitive(a);
        System.out.println(Arrays.toString(b));
        boolean[] c = ConvertTo.primitive(
                Generated.array(Boolean.class, new CountingGenerator.Boolean(), 7)
        );
        System.out.println(Arrays.toString(c));
    }
}
