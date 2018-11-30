package typeinfo;

/**
 * @author: liuHua
 * @create: 2018-11-30 09:38
 **/

public class GenericClassReferences {
	public static void main(String[] args) {
		Class intClass = int.class;
		Class<Integer> genericIntClass = int.class;
		genericIntClass = Integer.class;
		// genericIntClass = double.class // Illegal
		// Class<Number> genericNumberClass = int.class;
	}
}
