package generics;

import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-12 11:34
 **/

public class SuperTypeWildcards {
	static void writeTo(List<? super Apple> apples) {
		apples.add(new Apple());
		apples.add(new Jonathan());
		// apples.add(new Fruit()); //Error
	}
}
