package typeinfo;

/**
 * @author: liuHua
 * @create: 2018-11-30 09:44
 **/

public class BoundedClassReferences {
	public static void main(String[] args) {
		Class<? extends Number> bounded = int.class;
		bounded = double.class;
		bounded = Number.class;
		// Or anything else derived from Number
	}
}
