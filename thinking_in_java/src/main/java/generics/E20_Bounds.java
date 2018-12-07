package generics;

/**
 * @author: liuHua
 * @create: 2018-12-07 16:47
 * Create an interface with two methods, and a class
 * that implements that interface and adds another
 * method. In another class, create a generic method
 * with an argument type that is bounded by the
 * interface, and show that the methods in the interface are callable
 * inside this generic method.
 *
 **/
interface Top{
	void a();
	
	void b();
}

class CombinedImpl implements Top{
	@Override
	public void a() {
		System.out.println("Top::a()");
	}
	
	@Override
	public void b() {
		System.out.println("Top::b()");
	}
	
	public void c() {
		System.out.println("CombinedImpl::c()");
	}
}
public class E20_Bounds {
	static <T extends Top> void f(T obj) {
		obj.a();
		obj.b();
		// c() is not part of an interface
		// obj.c();
	}
	
	public static void main(String[] args) {
		f(new CombinedImpl());
	}
}
