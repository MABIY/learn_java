package typeinfo;

import static net.lh.util.Print.print;

/**
 * @author lh
 **/
interface Interface{
    void doSomething();

    void somethingElse(String arg);
}
class RealObject implements Interface{
    @Override
    public void doSomething() {
        print("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        print("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {
        private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        print("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        print("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}
public class SimpleProxyDemo {
    public static void consuemr(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consuemr(new RealObject());
        consuemr(new SimpleProxy(new RealObject()));
    }
}
