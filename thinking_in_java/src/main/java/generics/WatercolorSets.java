package generics;

import generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.Set;

import static generics.watercolors.Watercolors.*;
import static net.lh.util.Print.print;
import static net.lh.util.Sets.*;

/**
 * @author lh
 **/
public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        print("set1: " + set1);
        print("set2: " + set2);
        print("union(set1,set1): " + union(set1,set2));
        Set<Watercolors> subset = intersection(set1, set2);
        print("intersection(set1l,set2): " + subset);
        print("difference(set1,subset): " + difference(set1, subset));
        print("difference(set1,subset): " + difference(set2,subset));
        print("compleemnt(set1,set2): " + complement(set1,set2));
    }
}
