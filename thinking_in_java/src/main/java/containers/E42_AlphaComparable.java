package containers;

import net.lh.util.CollectionData;
import net.lh.util.Generated;
import net.lh.util.Generator;
import net.lh.util.RandomGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Modify Exercise 40 so that an alphabetic sort
 * is used
 **/

class TwoStringAlphabetic implements Comparable<TwoStringAlphabetic> {
    String s1, s2;

    public TwoStringAlphabetic(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public String toString() {
        return "[s1 = " + s1 + ", s2 = " + s2 + "]";
    }

    @Override
    public int compareTo(TwoStringAlphabetic o) {
        String rvi = o.s1;
        return s1.toLowerCase().compareTo(rvi.toLowerCase());
    }
    private static RandomGenerator.String gen = new RandomGenerator.String();

    public static Generator<TwoStringAlphabetic> generator() {
        return new Generator<TwoStringAlphabetic>() {
            @Override
            public TwoStringAlphabetic next() {
                return new TwoStringAlphabetic(gen.next(), gen.next());
            }
        };
    }
}

class CompareSecondAlphabetic implements Comparator<TwoStringAlphabetic>{
    @Override
    public int compare(TwoStringAlphabetic o1, TwoStringAlphabetic o2) {
        return o1.s2.toLowerCase().compareTo(o2.s2.toLowerCase());
    }
}
public class E42_AlphaComparable {
    public static void main(String[] args) {
        TwoStringAlphabetic[] array = new TwoStringAlphabetic[10];
        Generated.array(array, TwoStringAlphabetic.generator());
        print("before sorting, array = " + Arrays.asList(array));
        Arrays.sort(array);
        Arrays.sort(array, new CompareSecondAlphabetic());
        print("\nafter sorting with CompareSecondAlphabetic," + " array = " +Arrays.asList(array));
        ArrayList<TwoStringAlphabetic> list = new ArrayList<>(
                CollectionData.list(
                        TwoStringAlphabetic.generator(), 10
                )
        );
        TwoStringAlphabetic zeroth = list.get(0);
        print("\nbefore sorting, list = " + list);
        Collections.sort(list);
        print("\nafter sorting, list = " + list);
        Comparator<TwoStringAlphabetic> comp = new CompareSecondAlphabetic();
        Collections.sort(list,comp);
        print("\nafter sorting with CompareSecondAlphabetic," + " list = " + list);
        int index = Collections.binarySearch(list, zeroth, comp);
        print("\nFormer zeroth element " + zeroth + " now located at " + index);
    }
}
