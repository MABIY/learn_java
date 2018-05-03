package arrays;

import lh.com.util.ConvertTo;
import lh.com.util.CountingGenerator;
import lh.com.util.Generated;

import java.util.Arrays;

public class E12_GeneratedDArray {
    public static void main(String[] args) {
        double[] d = ConvertTo.primitive(Generated.array(Double.class, new CountingGenerator.Double(), 15));
        System.out.println(Arrays.toString(d));
        System.getProperty("java.util.prefs.systemRoot");
    }
}
