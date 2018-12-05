package generics.util;

import java.util.*;

/**
 * @author: liuHua
 * @create: 2018-12-05 13:31
 * Utilities to simplify generic container creation
 * by using type argument inference
 **/

public class New {
	public static <K,V> Map<K,V> map() {
		return new HashMap<K,V>();
	}
	
	public static <T> List<T> list() {
		return new ArrayList<>();
	}
	public static <T> LinkedList<T> lList() {
		return new LinkedList<>();
	}
	
	public static <T> Set<T> set() {
		return new HashSet<>();
	}
	
	public static <T> Queue<T> queue() {
		return new LinkedList<>();
	}
	
	// Examples:
	public static void main(String[] args) {
		Map<String, List<String>> sls = New.map();
		List<String> ls = New.list();
		LinkedList<String> lls = New.lList();
		Set<String> ss = New.set();
		Queue<String> qs = New.queue();
	}
}
