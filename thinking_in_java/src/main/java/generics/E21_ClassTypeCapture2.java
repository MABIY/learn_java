package generics;

import java.util.HashMap;
import java.util.Map;

import static access.util.Print.print;

/*
 * Modify classTypeCapture.java by adding a
 * Mpa<String,Class<?>> , a method
 * addType(String typename,Class<?> kind), add a
 * method createNew(String typename). createNew()
 * will either produce a new instance of hte class
 * associated with its argument string,or produce
 * an error message
 */
class ClassTypeCapture2{
    Map<String, Class<?>> types = new HashMap<>();

    public Object createNew(String typename) {
        Class<?> cl = types.get(typename);
        try {
            return cl.newInstance();
        } catch (IllegalAccessException e) {
            print("Not a registered typename: " + typename);
        } catch (Exception e) {
            print(e.toString());
        }
        return null;
    }

    public void addType(String typename, Class<?> kind) {
        types.put(typename, kind);
    }
}
public class E21_ClassTypeCapture2 {
    public static void main(String[] args) {
        ClassTypeCapture2 ctt = new ClassTypeCapture2();
        ctt.addType("Building",Building.class);
        ctt.addType("House",House.class);
        ctt.addType("Product", Product.class);
        print(ctt.createNew("Building").getClass());
        print(ctt.createNew("House").getClass());
        ctt.createNew("Product");
        ctt.createNew("Car");
    }
}
