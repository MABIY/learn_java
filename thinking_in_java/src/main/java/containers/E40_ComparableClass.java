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
 * Create a class containing two string objects
 * and make it Comparable so that the comparison
 * only cares about the first String. Fill an array
 * and an ArrayList with objects of your class.
 * using the RandomGenerator generator. Demonstarte that
 * sorting works properly. Now make a Comparator that
 * only cares about the second String, and demonstrate
 * that sorting works properly. Also perform a binary
 * search using your Comparator
 **/
class TwoString implements Comparable<TwoString> {
    String s1 , s2;

    public TwoString(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public String toString() {
        return "[s1 = " + s1 + ", s2 = " + s2 + "]";
    }

    @Override
    public int compareTo(TwoString o) {
        String rvi = o.s1;
        return s1.compareTo(rvi);
    }

    private static RandomGenerator.String gen = new RandomGenerator.String();
    public static Generator<TwoString> generator() {
        return new Generator<TwoString>() {
            @Override
            public TwoString next() {
                return new TwoString(gen.next(), gen.next());
            }
        };
    }
}
class CompareSecond implements Comparator<TwoString> {
    @Override
    public int compare(TwoString o1, TwoString o2) {
        return o1.s2.compareTo(o2.s2);
    }
}

public class E40_ComparableClass {
    public static void main(String[] args) {
        TwoString[] array = new TwoString[10];
        Generated.array(array, TwoString.generator());
        print("before sorting, array = " + Arrays.asList(array));
        Arrays.sort(array);
        System.out.println("sort = " + Arrays.asList(array));
        Arrays.sort(array, new CompareSecond());
        print("\nafter sorting with CompareSecond, array = " + Arrays.asList(array));
        ArrayList<TwoString> list = new ArrayList<>(
                CollectionData.list(TwoString.generator(), 10)
        );
        TwoString zeroth = list.get(0);
        print("\nbefore sorting, list = " + list);
        Collections.sort(list);
        print("\nafter sorting ,list = " + list);
        Comparator<TwoString> comp = new CompareSecond();
        Collections.sort(list, comp);
        print(
                "\nafter sorting with CompareSecond, list = " + list
        );
        int index = Collections.binarySearch(list, zeroth, comp);
        print("\nFormer zeroth element " + zeroth + " now located at " + index);
    }
}
