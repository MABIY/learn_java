package typeinfo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import typeinfo1.classa.A;

public class E25_HiddenMethodCalls {
    static void callHiddenMethod(Object a, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        class B extends A{
            protected void b() {
                super.b();
            }
        }

        A objA = new A();
//        objA.a(); //Compile time error
//        objA.b(); //Compile time error
//        objA.c(); //Compile time error
        callHiddenMethod(objA,"a");
        callHiddenMethod(objA,"b");
        callHiddenMethod(objA,"c");
    }
}
