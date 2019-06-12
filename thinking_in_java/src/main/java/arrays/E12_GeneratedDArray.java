package arrays;

import net.lh.util.ConvertTo;
import net.lh.util.CountingGenerator;
import net.lh.util.Generated;

import java.util.Arrays;

/**
 * @author lh
 * Create an initialized array of double using
 * CountingGenerator.Print the results
 **/
public class E12_GeneratedDArray {
    public static void main(String[] args) {
        double[] d = ConvertTo.primitive(Generated.array(Double.class, new CountingGenerator.Double(), 15));
        System.out.println(Arrays.toString(d));
    }
}
