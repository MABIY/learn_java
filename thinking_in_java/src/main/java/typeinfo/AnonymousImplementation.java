package typeinfo;

import java.lang.reflect.InvocationTargetException;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Anonymous inner classes can't hide form reflection.
 **/

class AnonymousA{
    public static typeinfo.interfacea.A makeA() {
        return new typeinfo.interfacea.A() {
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
        typeinfo.interfacea.A a = AnonymousA.makeA();
        System.out.println(a.getClass().getName());
        // Reflection still gets into the anonymous class:
        HiddenImplementation.callHiddenMethod(a,"g");
        HiddenImplementation.callHiddenMethod(a,"u");
        HiddenImplementation.callHiddenMethod(a,"v");
        HiddenImplementation.callHiddenMethod(a,"w");

    }
}
