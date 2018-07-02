package typeinfo1;


interface Interface1 {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject1 implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy1 implements Interface {
    private Interface proxied;

    public SimpleProxy1(Interface proxied) {
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

}
