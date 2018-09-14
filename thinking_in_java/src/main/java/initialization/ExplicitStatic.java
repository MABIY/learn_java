package initialization;

import static org.greggordon.tools.Print.print;

class Cup{
    Cup(int marker) {
        print("Cup(" + marker + ")");
    }

    void f(int marker) {
        print("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;
    static Cup cup3 = new Cup(4);
    static {
        cup1  = new Cup(1);
        cup2 = new Cup(2);
        cup3 = new Cup(3);
    }


    public Cups() {
        print("Cups");
        System.out.println();
    }
}
public class ExplicitStatic {
    public static void main(String[] args) {
        print("Inside main()");
        Cups.cup1.f(99);
    }
    static Cups cups1 = new Cups();
    static Cups cups2 = new Cups();

}
