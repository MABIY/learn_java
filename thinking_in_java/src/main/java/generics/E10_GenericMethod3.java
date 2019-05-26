package generics;

/**
 * @author lh
 * Modify  the previous exercise so that one of
 * f()'s arguments is non-parameterized
 **/
public class E10_GenericMethod3 {
    public <A, B> void f(A a, B b, Boolean c) {
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(c.getClass().getName());
    }

    public static void main(String[] args) {
        E10_GenericMethod3 gm = new E10_GenericMethod3();
        gm.f("",1,true);
        gm.f(1.0,1.0F,false);
        gm.f('c',gm,true);
    }
}
