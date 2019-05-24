package typeinfo;

import java.lang.reflect.InvocationTargetException;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Private inner classes can't hide from reflection.
 **/
class InnerA{
    private static class C implements typeinfo.interfacea.A{

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

        protected void w() {
            print("private C.w()");
        }
    }

    public static typeinfo.interfacea.A makeA() {
        return new C();
    }
}
public class InnerImplementation {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        typeinfo.interfacea.A a = InnerA.makeA();
        System.out.println(a.getClass().getName());
        // Reflection still  gets into the private class:
        HiddenImplementation.callHiddenMethod(a,"g");
        HiddenImplementation.callHiddenMethod(a,"u");
        HiddenImplementation.callHiddenMethod(a,"v");
        HiddenImplementation.callHiddenMethod(a,"w");
    }
}
