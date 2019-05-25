package generics;

/**
 * @author lh
 * Create a holder class that holds three objects
 * of the same type, along with the methods to
 * store and fetch those objects and a constructor
 * to initialize all three.
 **/
class HOlder4<T> {
    private T a, b, c;

    public HOlder4(T a, T b, T c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public T getB() {
        return b;
    }

    public void setB(T b) {
        this.b = b;
    }

    public T getC() {
        return c;
    }

    public void setC(T c) {
        this.c = c;
    }
}

public class E02_Holder4 {
    public static void main(String[] args) {
        HOlder4<String> h4 = new HOlder4<>("A","B","C");
        System.out.println(h4.getA());
        System.out.println(h4.getB());
        System.out.println(h4.getC());
        h4.setC("D");
        System.out.println(h4.getC());
    }
}
