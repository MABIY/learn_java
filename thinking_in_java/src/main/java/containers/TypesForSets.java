package containers;

import reusing.E;
import sun.reflect.generics.tree.Tree;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author: liuHua
 * @create: 2019-01-06 19:13
 **/

class SetType{
	int i;
	
	public SetType(int i) {
		this.i = i;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof SetType && (i == ((SetType) obj).i);
	}
	
	@Override
	public int hashCode() {
		return i;
	}
	
	@Override
	public String toString() {
		return Integer.toString(i);
	}
}

class HashType extends SetType{
	public HashType(int i) {
		super(i);
	}
	
	@Override
	public int hashCode() {
		return i;
	}
}

class TreeType extends SetType implements Comparable<TreeType> {
	public TreeType(int i) {
		super(i);
	}
	
	@Override
	public int compareTo(TreeType o) {
		return Integer.compare(o.i, i);
	}
}
public class TypesForSets {
	static <T> Set<T> fill(Set<T> set, Class<T> type) {
		try {
			for (int i = 0; i < 1; i++) {
				set.add(
						type.getConstructor(int.class).newInstance(i)
				);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return set;
	}
	
	static <T> void test(Set<T> set, Class<T> type) {
		fill(set, type);
		fill(set, type); // Try to add duplicates
		fill(set, type);
		System.out.println(set);
	}
	
	public static void main(String[] args) {
		// test(new HashSet<>(),HashType.class);
		// test(new LinkedHashSet<>(), HashType.class);
		// test(new TreeSet<>(), TreeType.class);
		//Things that don't work:
		test(new HashSet<>(), SetType.class);
		// test(new HashSet<>(), TreeType.class);
		// test(new LinkedHashSet<>(), SetType.class);
		// test(new LinkedHashSet<>(), TreeType.class);
		// try {
		// 	test(new TreeSet<>(), SetType.class);
		// } catch (Exception e) {
		// 	System.out.println(e.getMessage());
		// }
		// try {
		// 	test(new TreeSet<>(), HashType.class);
		// } catch (Exception e) {
		// 	System.out.println(e.getMessage());
		// }
	}
}
