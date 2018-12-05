package generics;

/**
 * @author: liuHua
 * @create: 2018-12-05 13:23
 * Modify GenericMethods.java so that f() accepts
 * three arguments, all of which are of a different
 * parameterized type
 **/

public class E09_GenericMethod2 {
	public <A, B, C> void f(A a, B b, C c) {
		System.out.println(a.getClass().getName());
		System.out.println(b.getClass().getName());
		System.out.println(c.getClass().getName());
	}
	
	public static void main(String[] args) {
		E09_GenericMethod2 gm = new E09_GenericMethod2();
		gm.f("",1,1.0);
		gm.f(1.0f,'C',gm);
	}
}
