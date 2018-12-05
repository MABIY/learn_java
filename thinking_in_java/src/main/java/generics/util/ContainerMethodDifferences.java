package generics.util;

import sun.reflect.generics.tree.Tree;

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
	
	static void difference(Class<?> subSet, Class<?> supSet) {
		System.out.println(subSet.getSimpleName() + " extends " + supSet.getSimpleName() + ", adds: ");
		Set<String> comp = Sets.difference(
				methodSet(subSet), methodSet(supSet)
		);
		comp.removeAll(object); // Don't show 'Object' methods
		System.out.println(comp);
		interfaces(subSet);
	}
	
	public static void main(String[] args) {
		System.out.println("Collection: " + methodSet(Collection.class));
		interfaces(Collection.class);
		difference(Set.class,Collections.class);
		difference(HashSet.class,Set.class);
		difference(LinkedHashSet.class,HashSet.class);
		difference(TreeSet.class,Set.class);
		difference(List.class,Collection.class);
		difference(TreeSet.class,Set.class);
		difference(List.class,Collection.class);
		difference(ArrayList.class,List.class);
		difference(LinkedList.class,List.class);
		difference(Queue.class,Collection.class);
		difference(PriorityQueue.class,Queue.class);
		System.out.println("map: " + methodSet(Map.class));
		difference(HashMap.class,Map.class);
		difference(LinkedHashMap.class,HashMap.class);
		difference(SortedMap.class,Map.class);
		difference(TreeMap.class, Map.class);
	}
	
}
