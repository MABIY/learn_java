package arrays;

import net.lh.util.CountingGenerator;
import net.lh.util.Generated;

import java.util.Arrays;

/**
 * @author lh
 **/
public class TestGenerated {
    public static void main(String[] args) {
        Integer[] a = {9, 8, 7, 6};
        System.out.println(Arrays.toString(a));
        Generated.array(a, new CountingGenerator.Integer());
        System.out.println(Arrays.toString(a));
        Integer[] b = Generated.array(Integer.class, new CountingGenerator.Integer(), 15);
    }
}
