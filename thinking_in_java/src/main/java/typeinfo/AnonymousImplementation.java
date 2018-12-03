package typeinfo;

import java.lang.reflect.InvocationTargetException;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-03 14:57
 **/

class AnonymousA{
	public static A makeA() {
		return new A() {
			@Override
			public void f() {
				print("public C.f()");
			}
			
			public void g() {
				print("public C.g()");
			}
			
			void u() {
				print("package C.u()");
			}
			
			protected void v() {
				print("protected C.v()");
			}
			
			private void w() {
				print("private C.w()");
			}
			
		};
	}
}
public class AnonymousImplementation {
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		A a = AnonymousA.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// Reflection still gets into the anonymous class:
		HiddenImplementation.callHiddenMethod(a,"g");
		HiddenImplementation.callHiddenMethod(a,"u");
		HiddenImplementation.callHiddenMethod(a,"v");
		HiddenImplementation.callHiddenMethod(a,"w");
	}
}
