package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lh
 * Inside invoke() in SimpleDynamicProxy.java
 * try to print the proxy argument and explain
 * what happends
 **/

class DynamicProxyHandler2 implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler2(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy: " + proxy);
        return method.invoke(proxied, args);
    }
}


public class E23_SimpleDynamicProxyDemo2 {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler2(real));
        consumer(proxy);
    }
}
