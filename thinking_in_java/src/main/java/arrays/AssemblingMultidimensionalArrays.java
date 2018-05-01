package arrays;

import java.util.Arrays;

public class AssemblingMultidimensionalArrays {
    public static void main(String[] args) {
        Integer[][] a;
        a = new Integer[3][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Integer[3];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = i * j; //AUtoboxing
            }
        }
        System.out.println(Arrays.deepToString(a));
        int[][] b = new int[3][3];
        System.out.println(Arrays.deepToString(b));
    }
}
