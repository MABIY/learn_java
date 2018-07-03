package typeinfo1;

import typeinfo1.interfacea.A;

import java.lang.reflect.InvocationTargetException;

class AnonymousA{
    public static A makeA() {
        return new A() {
            @Override
            public void f() {
                System.out.println("public C.f()");
            }

            public void g() {
                System.out.println("public C.g()");
            }

            void u() {
                System.out.println("package C.u()");
            }

            protected void v() {
                System.out.println("protected C.v()");
            }

            private void w() {
                System.out.println("private C.w()");
            }
        };
    }
}
public class AnonymousImplementation {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        A a = AnonymousA.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        // Reflection stil gets into the anonymnous class:
        HiddenImplementation.callHiddenMethod(a, "g");
        HiddenImplementation.callHiddenMethod(a, "u");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "v");
        HiddenImplementation.callHiddenMethod(a, "w");

    }
}
