package generics;

import java.util.HashMap;
import java.util.Map;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Modify ClassTypeCapture.java by adding a
 * Map<String,Class<?>>,a method addType(String typename,Class<?> kind), and
 * a method createnew(String,typename).createNew()
 * will either produce a new instance of the class
 * associated with its argument string, or produce an error message
 **/
class ClassTypeCapture2{
    Map<String, Class<?>> types = new HashMap<>();

    public Object createNew(String typename) {
        Class<?> cl = types.get(typename);
        try {
            return cl.newInstance();
        } catch (NullPointerException e) {
            print("Not a registered typename: " + typename);
        } catch (Exception e) {
            print(e.toString());
        }
        return null;
    }

    public void addTypes(String typename, Class<?> kind) {
        types.put(typename, kind);
    }
}
public class E21_ClassTypeCapture2 {
    public static void main(String[] args) {
        ClassTypeCapture2 ctt = new ClassTypeCapture2();
        ctt.addTypes("Building", Building.class);
        ctt.addTypes("House", House.class);
        ctt.addTypes("Product",Product.class);
        print(ctt.createNew("Building").getClass());
        print(ctt.createNew("House").getClass());
        ctt.createNew("Product");
        ctt.createNew("Car");
    }
}
