package containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2019-01-20 13:40
 * Modify the hashCode() in CountedString.java by
 * removing the combination with id, and demonstrate
 * that CountedString still works as a key. what is
 * the problem with this approach?
 **/

class CountedString3{
	private static List<String> created = new ArrayList<>();
	private String s;
	private int id = 0;
	
	public CountedString3(String s) {
		this.s = s;
		created.add(s);
		// id is the total number of instances
		// of this string in use by CountedString3:
		for (String s1 : created) {
			id++;
		}
	}
	
	@Override
	public String toString() {
		return "String: " + s + " id: " + id +
				" hashCode(): " + hashCode();
	}
	
	@Override
	public int hashCode() {
		// The very simple approach:
		// return s.hashCode()
		// Using Joshua Bloch's recipe:
		int result = 17;
		result = 37 * result + s.hashCode();
		// result = 37 * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof CountedString3 &&
				s.equals(((CountedString3) obj).s) &&
				id == ((CountedString3) obj).id;
	}
}
public class E27_CountedString3 {
	public static void main(String[] args) {
		Map<CountedString3, Integer> map = new HashMap<>();
		CountedString3[] cs = new CountedString3[5];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = new CountedString3("hi");
			map.put(cs[i], i); // Autobox int -> Integer
		}
		for (CountedString3 countedString3 : cs) {
			print("Looking up " + countedString3);
			print(map.get(countedString3));
		}
	}
}
