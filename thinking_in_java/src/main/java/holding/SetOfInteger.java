package holding;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author lh
 **/
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> insert = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            insert.add(rand.nextInt(30));
        }
        System.out.println(insert);
    }
}
