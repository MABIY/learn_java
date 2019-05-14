package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 * Repair InfiniteRecursion.java
 **/
public class E02_RepairInfinite {
    @Override
    public String toString() {
        return "E02_RepairInfinite address: " +
                super.toString() + System.lineSeparator();
    }

    public static void main(String[] args) {
        List<E02_RepairInfinite> v = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            v.add(new E02_RepairInfinite());
        }
        String.valueOf((short)1);
    }
}
