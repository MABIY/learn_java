package arrays;

import java.util.Arrays;

/**
 * @author lh
 * Demonstrate that multidimensional array of
 * non-primitive type are automatically initialized
 * to null
 **/
public class E05_NonPrimitiveMultiDArray {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Object[3][3][3]));
    }
}
