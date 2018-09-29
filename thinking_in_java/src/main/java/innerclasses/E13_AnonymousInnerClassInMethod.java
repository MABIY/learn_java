package innerclasses;

import innerclasses.exercise6.SimpleInterface;

public class E13_AnonymousInnerClassInMethod {
    public SimpleInterface get() {
        return new SimpleInterface() {
            @Override
            public void f() {
                System.out.println("SimpleInterface.f");
            }
        };
    }

    public static void main(String[] args) {
        SimpleInterface si = new E13_AnonymousInnerClassInMethod().get();
        si.f();
    }
}
