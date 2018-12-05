package generics.util;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author: liuHua
 * @create: 2018-12-05 17:18
 **/

public class ContainerMethodDifferences {
	static Set<String> methodSet(Class<?> type) {
		Set<String> result = new TreeSet<>();
		for (Method m : type.getMethods()) {
			result.add(m.getName());
		}
		return result;
	}
	
	static void interfaces(Class<?> type) {
		System.out.println("Interfaces in " +
				type.getSimpleName());
		
		List<String> result = new ArrayList<>();
		for (Class<?> c : type.getInterfaces()) {
			result.add(c.getSimpleName());
		}
		System.out.println(result);
		
	}
	
	static Set<String> object = methodSet(Object.class);
	static {
		object.add("clone");
	}
	
	static void difference(Class<?> superset, Class<?> subset) {
		System.out.println(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds: ");
		Set<String> comp = Sets.difference(
				methodSet(superset), methodSet(subset)
		);
		comp.removeAll(object); // Don't show 'Object' methods
		System.out.println(comp);
		interfaces(superset);
	}
	
	public static void main(String[] args) {
		System.out.println("Collection: " + methodSet(Collection.class));
		interfaces(Collection.class);
		difference(Set.class,Collections.class);
		//fixme
	}
	
}
