package typeinfo;

import static net.lh.util.Print.print;

/**
 * Modify SimpleProxyDemo.java so ti measures method-call times
 **/
class SimpleProxy1 implements Interface {
    private Interface proxied;

    public SimpleProxy1(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        print("SimpleProxy doSomething");
        long start = System.nanoTime();
        proxied.doSomething();
        long duration = System.nanoTime() - start;
        print("METHOD-CALL TIME: " + duration);
    }

    @Override
    public void somethingElse(String arg) {
        print("SimpleProxy somethingElse " + arg);
        long start = System.nanoTime();
        proxied.somethingElse(arg);
        long duration = System.nanoTime() - start;
        print("METHOD0-CALL TIME: " + duration);
    }
}
public class E21_SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy1(new RealObject()));
    }
}
