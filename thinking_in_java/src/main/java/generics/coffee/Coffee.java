package generics.coffee;

/**
 * @author: liuHua
 * @create: 2018-12-04 15:34
 **/

public class Coffee {
	private static long counter = 0;
	private final long id = counter++;
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
}
