package generics;

import java.util.HashMap;
import java.util.Map;

import static access.util.Print.print;

/*
 * Modify Exercise 21 so that Factory objects are
 * held in map instead of class<?>.
 */
class FactoryCapture{
    Map<String, FactoryI23<?>> factories = new HashMap<>();

    public Object createNew(String factoryname, int arg) {
        FactoryI23<?> f = factories.get(factoryname);
        try {
            return f.create(arg);
        } catch (Exception e) {
            print("Not a registered factoryname: " + factoryname);
        }
        return null;
    }

    public void addFactory(String factoryname, FactoryI23<?> factoryI23) {
        factories.put(factoryname, factoryI23);
    }
}
public class E24_FactoryCaputre {
    public static void main(String[] args) {
        FactoryCapture fc = new FactoryCapture();
        fc.addFactory("Integer", new IntegerFactory23());
        fc.addFactory("Widget", new Widget23.Factory());
        print(fc.createNew("Integer",1));
        print(fc.createNew("Widget",2));
        fc.createNew("Product", 3);
    }
}
