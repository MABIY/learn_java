package object;

public class OneStaticTest {
    public static void main(String[] args) {
        System.out.println("StaticTest.i=" +StaticTest.i);
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();
        System.out.println("st1.i = " + st1.i);
        System.out.println("st1.i = " + st2.i);
        Incrementable sf = new Incrementable();
        sf.increment();
        System.out.println("After sf.increment() called: ");
        System.out.println("st1.if = " + st1.i);
        System.out.println("st1.if = " + st2.i);
        Incrementable.increment();
        System.out.println("After Incrementable.increment() called: ");
        System.out.println("st1.if = " + st1.i);
        System.out.println("st1.if = " + st2.i);
        st1.i = 3;
        System.out.println("After st1.i = 3, ");
        System.out.println("st1.i = " + st1.i);
        System.out.println("st2.i = " + st2.i);
        System.out.println("Create another StaticTest, st3.");
        StaticTest st3 = new StaticTest();
        System.out.println("st3.i = " + st3.i);
    }
}
