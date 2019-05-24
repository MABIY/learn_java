package typeinfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author lh
 * Create a class containing private, protected and
 * package access methods. Write code to access these
 * methods from outside of the class's pacakge.
 **/
public class E25_HiddenMethodCalls {
    static void callHiddenMethod(Object a, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method g = a.getClass().getDeclaredMethod(methodName);
        a.getClass().getDeclaredFields();
        g.setAccessible(true);
        g.invoke(a);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        class B extends typeinfo.classa.A{
            @Override
            protected void b() {
                super.b();
            }
        }
        typeinfo.classa.A objA = new typeinfo.classa.A();
        // objA.a();  // Compile time error
        // objA.b();// Compile time error
        // objA.c();// Compile time error
        callHiddenMethod(objA,"a");
        callHiddenMethod(objA,"b");
        callHiddenMethod(objA,"c");
    }
}
