package containers;

import net.lh.util.CollectionData;
import net.lh.util.RandomGenerator;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author lh
 **/
public class CollectionDataGeneration {
    public static void main(String[] args) {
        System.out.println(new ArrayList<String>(
                CollectionData.list( // Convenience method
                        new RandomGenerator.String(9), 10
                )
        ));

        System.out.println(new HashSet<Integer>(
                new CollectionData<>(
                        new RandomGenerator.Integer(), 10
                )
        ));
    }
}
