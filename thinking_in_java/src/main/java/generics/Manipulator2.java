package generics;

/**
 * @author: liuHua
 * @create: 2018-12-06 17:18
 **/

public class Manipulator2<T extends HasF> {
	private T obj;
	
	public Manipulator2(T obj) {
		this.obj = obj;
	}
	
	public void mainpulate() {
		obj.f();
	}
}
