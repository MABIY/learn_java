package containers;

import net.lh.util.CollectionData;
import net.lh.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author lh
 **/
class Government implements Generator<String>{
    String[] foundation = ("strange women lying in ponds " +
            "distributing swords is no basic for a system of " +
            "government").split(" ");
    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}

public class CollectionDataTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>(
                new CollectionData<>(new Government(), 15)
        );
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
}
