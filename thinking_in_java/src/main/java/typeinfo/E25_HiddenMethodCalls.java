package typeinfo;

import typeinfo.classa.A;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: liuHua
 * @create: 2018-12-03 15:45
 * Create a class containing private,protected and
 * package access methods.Write code to access these
 * methods from outside of the class's package
 **/

public class E25_HiddenMethodCalls {
	static void callHiddenMethod(Object a, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}
	
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		class B extends A {
			public void b() {
				super.b();
			}
		}
		
		A objA = new A();
		// objA.a(); Compile time error
		// objA.b(); Compile time error
		// objA.c(); Compile time error
		callHiddenMethod(objA,"a");
		callHiddenMethod(objA,"b");
		callHiddenMethod(objA,"c");
		B objB = new B();
		objB.b();
	}
}
