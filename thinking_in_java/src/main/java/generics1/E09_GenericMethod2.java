package generics1;

public class E09_GenericMethod2 {
    public <A, B, C> void f(A a, B b, C c) {
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(c.getClass().getName());
    }

    public static void main(String[] args) {
        E09_GenericMethod2 gm = new E09_GenericMethod2();
        gm.f("", 1, 1.0);
        gm.f(1.0F,'c',gm);
    }
}
