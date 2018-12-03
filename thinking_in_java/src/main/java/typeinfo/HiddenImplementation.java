package typeinfo;

import typeinfo.packageaccess.HiddenC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: liuHua
 * @create: 2018-12-03 14:45
 **/

public class HiddenImplementation {
	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		A a = HiddenC.makeA();
		a.f();
		System.out.println(a.getClass().getName());
		// Compile error: cannot find symbol 'C'
		// if (a instanceof C) {
		//
		// }
		// Oops! Reflection still allows us to call g();
		callHiddenMethod(a, "g");
		callHiddenMethod(a, "u");
		callHiddenMethod(a, "v");
		callHiddenMethod(a, "w");
		
	}
	
	static void callHiddenMethod(Object a, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}
}
