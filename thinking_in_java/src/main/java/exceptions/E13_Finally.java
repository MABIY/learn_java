package exceptions;

/**
 * @author lh
 * Modify Exercise 9 by adding a finally clause.
 * Verify that your finally clause is executed,
 * even if a NullPointerException is thrown.
 **/
public class E13_Finally {
    public static void thrownNull() {
        throw new NullPointerException();
    }

    public static void main(String[] args) {
        Thrower2 t = new Thrower2();
        try {
            t.f();
        } catch (ExBase e) {
            System.out.println("caught " +e);
        }finally {
            System.out.println("In finally clause  A");
        }
        try {
            thrownNull();
            t.f();
        } catch (ExBase e) {
            System.out.println("caught " + e);
        } finally {
            System.out.println("In finally clause B");
        }
    }
}
