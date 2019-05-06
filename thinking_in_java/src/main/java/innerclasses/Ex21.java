package innerclasses;

/**
 * @author lh
 * Create an interface that contains a nested class that has a static method that
 * calls the methods of your interface and displays
 **/
interface In21{
    String f();
    String g();
    class Nested{
        static void testIn(In21 i) {
            System.out.println(i.f() + i.g());
        }
    }
}

public class Ex21 implements In21 {
    @Override
    public String f() {
        return "hello ";
    }

    @Override
    public String g() {
        return "friend";
    }

    public static void main(String[] args) {
        Ex21 x = new Ex21();
        In21.Nested.testIn(x);
    }
}
