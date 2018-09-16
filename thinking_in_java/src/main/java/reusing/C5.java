package reusing;

import static org.greggordon.tools.Print.println;

class A5{
    A5() {
        println("A()");
    }
}

class B5 extends A5{
    B5() {
        println("B()");
    }
}

public class C5 extends A5 {

    /**
     *will then construct another A and then a B
     */
    B5 b = new B5();

    public static void main(String[] args) {
        /**
         * will construct an A first
         */
        C5 c = new C5();
    }
}
