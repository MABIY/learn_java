package generics1;

import java.util.HashMap;
import java.util.Map;

class FactoryCapture{
    Map<String, FactoryI1<?>> factories = new HashMap<>();

    public Object createNew(String factoryName, int arg) {
        FactoryI1<?> f = factories.get(factoryName);
        try {
            return f.create(arg);
        } catch (NullPointerException e) {
            System.out.println("Not a registered factoryName: " + factoryName);
            return null;
        }
    }

    public void addFactory(String factoryName, FactoryI1<?> factory) {
        factories.put(factoryName, factory);
    }
}
public class E24_FactoryCapture {
    public static void main(String[] args) {
        FactoryCapture fc = new FactoryCapture();
        fc.addFactory("Integer", new IntegerFactory1());
        fc.addFactory("Widget", new Widget1.Factory());
        System.out.println(fc.createNew("Integer",1));
        System.out.println(fc.createNew("Widget",2));
        fc.createNew("Product", 3);
    }
}
