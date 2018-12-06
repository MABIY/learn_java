package generics;

/**
 * @author: liuHua
 * @create: 2018-12-06 17:14
 **/

class Manipulator<T> {
	private T obj;
	
	public Manipulator(T obj) {
		this.obj = obj;
	}
	
	// Error: cannot find symbol: method f():
	public void manipulate() {
		// obj.f();
	}
	
}
public class Manipulation<T> {
	public static void main(String[] args) {
		HasF hf = new HasF();
		Manipulator<HasF> manipulator = new Manipulator<>(hf);
		manipulator.manipulate();
	}
	
}
