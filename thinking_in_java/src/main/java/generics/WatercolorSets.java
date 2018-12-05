package generics;

import generics.util.Sets;
import generics.watercolors.Watercolors;

import java.util.EnumSet;
import java.util.Set;

import static access.util.Print.print;
import static generics.watercolors.Watercolors.*;
import static javax.management.ImmutableDescriptor.union;

/**
 * @author: liuHua
 * @create: 2018-12-05 17:02
 **/

public class WatercolorSets {
	public static void main(String[] args) {
		Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
		Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
		print("set1: " + set1);
		print("set2: " + set2);
		print("union(set1,set2): " + Sets.union(set1, set2));
		Set<Watercolors> subset = Sets.intersection(set1, set2);
		print("intersection(set1,set2): " + subset);
		print("difference(set1,subset): " + Sets.difference(set2, subset));
		print("complement(set1,set2): " + Sets.complement(set1,set2));
	}
}
