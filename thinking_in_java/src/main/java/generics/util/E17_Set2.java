package generics.util;

import generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static access.util.Print.print;
import static generics.util.Sets2.union;
import static generics.watercolors.Watercolors.*;

/*
 Study the jdk documentation for EnumSet.You'll
 see there's a clone() method.
 However ,you cannot  clone() from the reference
 to the Set interface passed in Sets.java Can you
 modify Sets.java to handle both the general case
 of a Set interface as shown, and the special case
 of an EnumSet,using clone() instead of creating
 a new HashSet?
 */
class Sets2{
    @SuppressWarnings("uncheked")
    protected static <T> Set<T> copy(Set<T> s) {
        if (s instanceof EnumSet) {
            return ((EnumSet) s).clone();
        }
        return new HashSet<>(s);
    }

    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = copy(a);
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = copy(a);
        result.retainAll(b);
        return result;
    }

    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = copy(subset);
        result.removeAll(subset);
        return result;
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}
public class E17_Set2 {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        print("st1: " + set1);
        print("st2: " + set2);
        print("union(set1,set2):" + union(set1, set2));
        print("union(set1,set2) type: " + Sets2.union(set1,set2).getClass().getSimpleName());
        Set<Integer> set3 = new HashSet<>();
        set3.add(1);
        Set<Integer> set4 = new HashSet<>();
        set4.add(2);
        print("set3: " + set3);
        print("set4: " + set4);
        print("union(set3,set4): " + Sets2.union(set3, set4));
        print("union(set3,set4) type: " + Sets2.union(set3,set4).getClass().getSimpleName());
    }
}