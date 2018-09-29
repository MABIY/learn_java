package innerclasses;

class WithInner{
    class Inner{
        void f() {
            System.out.println("f");
        }
    }
}

public class InheritInner extends WithInner.Inner {
    //! InheritInner(){} //Won't compile

    public InheritInner(WithInner withInner) {
        withInner.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
        ii.f();
    }
}
