package typeinfo;

import typeinfo.packageaccess.HIddenC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lh
 * Sneaking arounmd package access
 **/
public class HiddenImplementation {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        typeinfo.interfacea.A a = HIddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Compile error: cannot find symbol 'C':
        // if (a instanceof typeinfo.packageaccess.C) {
        //     typeinfo.packageaccess.C  c = (typeinfo.packageaccess.C)a;
        //     c.g();
        // }

        // Oops! Reflection still allows us to call g();
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
