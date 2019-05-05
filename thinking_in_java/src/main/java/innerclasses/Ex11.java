package innerclasses;

/**
 * @author lh
 * Create a private Inner classes that implements a public interface.
 * Write a method that returns a reference to an instance of the private
 * inner class , upcast to the interface. Show that the inner class is
 * completely hidden by trying to downcast to it.
 **/
class Test{
    private class Inner implements Ex11Interface{
        @Override
        public void say(String s) {
            System.out.println(s);
        }
    }
    Ex11Interface f() {
        return new Inner();
    }
}
public class Ex11 {
    public static void main(String[] args) {
        Test t = new Test();
        t.f().say("hi");
        // Error: cannot find symbol: class Inner:
        // ((Inner) t.f()).say("heelo");
    }
}
