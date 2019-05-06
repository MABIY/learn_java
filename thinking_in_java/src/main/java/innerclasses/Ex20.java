package innerclasses;

/**
 * @author lh
 * Create an interface contianing a nested class. Implement this interface and
 * create an instance of the nested class.
 **/
interface In{
    class Nested{
        Nested() {
            System.out.println("Nested()");
        }
        public void hi() {
            System.out.println("hi");
        }
    }
}
public class Ex20 implements In{
    public static void main(String[] args) {
        In.Nested in = new In.Nested();
        in.hi();
    }
}
