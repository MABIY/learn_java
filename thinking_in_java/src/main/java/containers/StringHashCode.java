package containers;

/**
 * @author: liuHua
 * @create: 2019-01-20 12:57
 **/

public class StringHashCode {
	public static void main(String[] args) {
		String[] hellos = "Hello Hello".split(" ");
		System.out.println(hellos[0].hashCode());
		System.out.println(hellos[1].hashCode());
	}
}
