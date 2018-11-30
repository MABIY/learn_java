package typeinfo;

/**
 * @author: liuHua
 * @create: 2018-11-30 09:42
 **/

public class WildcardClassReferences {
	public static void main(String[] args) {
		Class<?> intClass = int.class;
		intClass = double.class;
	}
}
