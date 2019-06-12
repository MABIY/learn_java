package arrays;

import net.lh.util.Generated;
import net.lh.util.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify ContainerComparison.java by creating a
 * Generator for BerylliumSphere, and change main()
 * to use that Generator with Generated.array()
 **/

class BSGenerator implements Generator<BerylliumSphere> {

    @Override
    public BerylliumSphere next() {
        return new BerylliumSphere();
    }
}
public class E15_BSContainerComparison {
    public static void main(String[] args) {
        BSGenerator gen = new BSGenerator();
        BerylliumSphere[] spheres = Generated.array(
                BerylliumSphere.class, gen, 5
        );
        print(Arrays.toString(spheres));
        print(spheres[4]);

        List<BerylliumSphere> sphereList = Arrays.asList(
                Generated.array(BerylliumSphere.class, gen, 5)
        );
        print(sphereList);
        print(sphereList.get(4));

        int[] integers = {0, 1, 2, 3, 4, 5};
        print(Arrays.toString(integers));
        print(integers[4]);

        List<Integer> intList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        intList.add(97);
        print(intList);
        print(intList.get(4));
    }
}
