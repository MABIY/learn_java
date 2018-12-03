package typeinfo;

import java.lang.reflect.InvocationTargetException;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-03 14:51
 **/

class InnerA{
	private static class C implements A{
		@Override
		public void f() {
			print("public C.f()");
		}
		
		public  void g() {
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
	}
	
	public static A makeA() {
		return new C();
	}
}
public class InnerImplementation {
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		A a = InnerA.makeA();
		System.out.println(a.getClass().getName());
		// Reflection still gets into the private class
		HiddenImplementation.callHiddenMethod(a, "g");
		HiddenImplementation.callHiddenMethod(a, "u");
		HiddenImplementation.callHiddenMethod(a, "v");
		HiddenImplementation.callHiddenMethod(a, "w");
	}
}
