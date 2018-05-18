package typeinfo1;

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}

class Toy{
    //Toy(){}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots {
    public FancyToy() {
        super(1);
    }
}
public class E01_ToyTest {
    static void printInfo(Class<?> cc) {
        System.out.println("Class name: " + cc.getName()
                + "is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name:" + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("typeinfo1.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            return;
        }
        printInfo(c);
        for (Class<?> face : c.getInterfaces()) {
            printInfo(face);
        }
        Class<?> up = c.getSuperclass();
        Object obj = null;
        try {
            //Requires defualt constructor:
            obj = up.newInstance();
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            return;
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            return;
        }
        printInfo(obj.getClass());
    }
}
