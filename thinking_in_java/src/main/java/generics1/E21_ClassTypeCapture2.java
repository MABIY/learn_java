package generics1;


import java.util.HashMap;
import java.util.Map;

class ClassTypeCapture2 {
    Map<String, Class<?>> types = new HashMap<>();

    public Object createNew(String typeName) {
        Class<?> c1 = types.get(typeName);
        try {
            return c1.newInstance();
        } catch (NullPointerException e) {
            System.out.println("Not a registered typename: " + typeName);
        } catch (Exception e) {
            System.out.println(e.toString());
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
        ctt.addType("Building", Building.class);
        ctt.addType("House", House.class);
        ctt.addType("Product", Product.class);
        System.out.println(ctt.createNew("Building").getClass());
        System.out.println(ctt.createNew("House").getClass());
        ctt.createNew("Product");
        ctt.createNew("Car");
    }
}
