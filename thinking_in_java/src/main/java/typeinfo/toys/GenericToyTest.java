package typeinfo.toys;

/**
 * @author: liuHua
 * @create: 2018-11-30 09:51
 **/

public class GenericToyTest {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		Class<FancyToy> ftClass = FancyToy.class;
		// Produces exact type:
		FancyToy fancyToy = ftClass.newInstance();
		Class<? super FancyToy> up = ftClass.getSuperclass();
		// This won't compile:
		// Class<Toy> up2 = ftClass.getSuperclass();
		// Only produces Object:
		Object obj = up.newInstance();
	}
}
