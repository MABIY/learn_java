package generics;

/**
 * @author: liuHua
 * @create: 2018-12-17 13:27
 **/

interface GenericsGetter<T extends GenericsGetter<T>>{
	T get();
}

interface Getter extends GenericsGetter<Getter> {
}
public class GenericsAndReturnTypes {
	void test(Getter g) {
		Getter result = g.get();
		GenericsGetter gg = g.get(); //Also the base type
	}
}
