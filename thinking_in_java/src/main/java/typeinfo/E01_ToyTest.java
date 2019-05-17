package typeinfo;

import static net.lh.util.Print.print;

/**
 * In ToyTest.java, comment out Toy's default constructor
 * and explain what happens
 **/
interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
class Toy{
    public Toy() {
    }

    public Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {

    public FancyToy(int i) {
        super(i);
    }

    public FancyToy() {
    }
}
public class E01_ToyTest {
    static void printInfo(Class<?> cc) {
        print("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("typeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            print("Can't find FancyToy");
            return;
        }
        printInfo(c);
        for (Class<?> face : c.getInterfaces()) {
            printInfo(face);
        }
        Class<?> up = c.getSuperclass();
        Object object = null;
        try {
            // Requires default constructor
            object = up.newInstance();
        } catch (IllegalAccessException e) {
            print("Cannot access");
        } catch (InstantiationException e) {
            print("Cannot instantiate");
            return;
        }
        printInfo(object.getClass());

    }
}
