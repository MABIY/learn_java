package generics;

import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify Exercise 21 so that factory objects are
 * held in the Map instead of Class<?>
 **/
class FactoryCapture{
    Map<String, FactoryI23<?>> factories = new HashMap<>();

    public Object createNew(String factoryname, int arg) {
        FactoryI23<?> f = factories.get(factoryname);
        try {
            return f.create(arg);
        } catch (NullPointerException e) {
            print("Not a registered factorynam: " + factoryname);
        }
        return null;
    }

    public void addFactory(String factoryname, FactoryI23<?> factory) {
        factories.put(factoryname, factory);
    }
}
public class E24_FactroyCapture {
    public static void main(String[] args) {
        FactoryCapture fc = new FactoryCapture();
        fc.addFactory("Integer", new IntegerFactory23());
        fc.addFactory("Widget", new Widget23.Factory());
        print(fc.createNew("Integer", 1));
        fc.createNew("Product", 3);
    }
}
