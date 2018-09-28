package innerclasses;

import innerclasses.exercise6.SimpleInterface;

public class E10_InnerClassInScope {
    public SimpleInterface get() {
        {
            class SI implements SimpleInterface{
                @Override
                public void f() {
                    System.out.println("SI.f");
                }
            }
            return new SI();
        }
    }

    public static void main(String[] args) {
        SimpleInterface si = new E10_InnerClassInScope().get();
        si.f();
    }
}
