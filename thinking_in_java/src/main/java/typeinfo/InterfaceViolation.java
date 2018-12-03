package typeinfo;

/**
 * @author: liuHua
 * @create: 2018-12-03 14:37
 * sneaking around an interface
 **/

class B implements A{
	@Override
	public void f() {
	}
	
	public void g() {
	
	}
}
public class InterfaceViolation {
	public static void main(String[] args) {
		A a = new B();
		// a.g(); //Compile error
		System.out.println(a.getClass().getName());
		if (a instanceof B) {
			B b = (B) a;
			b.g();
		}
	}
}
