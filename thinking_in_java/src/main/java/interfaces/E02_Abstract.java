package interfaces;

abstract class NoAbstractMethods{
    void f() {
        System.out.println("f()");
    }
}

public class E02_Abstract {
    public static void main(String[] args) {
        //! new NoAbstractMethods();
    }
}
