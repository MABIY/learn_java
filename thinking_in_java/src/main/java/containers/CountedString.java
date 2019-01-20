package containers;

import control.Count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2019-01-20 13:01
 **/

public class CountedString {
	private static List<String> created = new ArrayList<>();
	private String s;
	private int id = 0;
	
	public CountedString(String s) {
		this.s = s;
		created.add(s);
		// id is the total number of instances
		// of this string in use by CountedString:
		for (String s2 : created) {
			if (s2.equals(s)) {
				id++;
			}
		}
	}
	
	@Override
	public String toString() {
		return "String " + s + " id: " + id +
				" hashCode(): " + hashCode();
	}
	
	@Override
	public int hashCode() {
		// The very simple approach:
		// return s.hashCode()*id:
		// Using Joshua Bloch's recipe:
		int result = 17;
		result = 37 * result + s.hashCode();
		result = 37 * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof CountedString &&
				s.equals(((CountedString) obj).s) &&
				id == ((CountedString) obj).id;
	}
	
	public static void main(String[] args) {
		Map<CountedString, Integer> map = new HashMap<>();
		CountedString[] cs = new CountedString[5];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = new CountedString("hi");
			map.put(cs[i], i); // Autobox int -> Integer
		}
		print(map);
		for (CountedString cstring : cs) {
			print("Looking up " + cstring);
			print(map.get(cstring));
		}
	}
}
