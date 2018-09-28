package innerclasses;

import access.SingleImport;
import innerclasses.exercise6.SimpleInterface;

class Outer5{
    private class Inner implements SimpleInterface {
        @Override
        public void f() {
            System.out.println("Outer5.Inner.f");
        }
    }

    public SimpleInterface get() {
        return new Inner();
    }

    public Inner get2() {
        return new Inner();
    }
}
public class E11_HiddenInnerClass {
    public static void main(String[] args) {
        Outer5 out = new Outer5();
        SimpleInterface si = out.get();
        si = out.get2();
        //Won't compile -- 'Inner' not visible
        // Outer5.Inner i1 = out.get2();
        // Outer5.Inner i2 = (Outer5.Inner) si;

    }
}
