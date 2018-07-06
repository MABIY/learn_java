package generics1;

import lh.com.util.CountingGenerator;
import net.mindview.util.Generator;

public class E06_RandomListTest {
    private static void dump(RandomList<?> rl) {
        for (int i = 0; i < 11; i++) {
            System.out.print(rl.select() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
