package typeinfo1;


interface Interface1 {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject1 implements Interface1 {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy1 implements Interface1 {
    private Interface1 proxied;

    public SimpleProxy1(Interface1 proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimapleProxy doSomething");
        long start = System.nanoTime();
        proxied.doSomething();
        long duration = System.nanoTime() - start;
        System.out.println("METHOD-CALL TIME: " + duration);
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        long start = System.nanoTime();
        proxied.somethingElse(arg);
        long duration = System.nanoTime() - start;
        System.out.println("METHOD-CALL TIME: " + duration);
    }
}
public class E21_SimpleProxyDemo {

    public static void consumer(Interface1 iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject1());
        consumer(new SimpleProxy1(new RealObject1()));
    }
}
