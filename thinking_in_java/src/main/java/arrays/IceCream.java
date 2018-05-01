package arrays;

import java.util.Arrays;
import java.util.Random;

public class IceCream {
    private static Random rand = new Random(47);
    static final String[] FLAVORS = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raishin",
            "Praline Cream", "Mud Pie"
    };

    public static String[] flavorSet(int n) throws IllegalAccessException {
        if (n > FLAVORS.length) {
            throw new IllegalAccessException("Set too big");
        }
        String[] results = new String[n];
        boolean[] picked = new boolean[FLAVORS.length];
        for (int i = 0; i < n; i++) {
            int t;
            do
                t = rand.nextInt(FLAVORS.length);
            while (picked[t]);
            results[i] = FLAVORS[t];
            picked[t] = true;
        }
        return results;
    }

    public static void main(String[] args) throws IllegalAccessException {
        for (int i = 0; i < 7; i++) {
            System.out.println(Arrays.toString(flavorSet(3)));
        }
    }
}
