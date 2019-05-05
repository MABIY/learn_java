package innerclasses;

/**
 * @author lh
 * Modify Exercise 1 so that Outer has a private String field (initialized
 * by the constructor), and Inner has a toString() that display this field.
 * Create an object of type Inner and display it.
 **/
public class Outer3 {
    private String s;
    class Inner3{
        public Inner3() {
            System.out.println("Inner()");
        }

        @Override
        public String toString() {
            return s;
        }
    }

    public Outer3(String s) {
        System.out.println("Outer1()");
        this.s = s;
    }

    Inner3 makeInner3() {
        return new Inner3();
    }

    public static void main(String[] args) {
        Outer3  o = new Outer3("Hi is risen!");
        Inner3 i = o.makeInner3();
        System.out.println(i.toString());
    }
}
