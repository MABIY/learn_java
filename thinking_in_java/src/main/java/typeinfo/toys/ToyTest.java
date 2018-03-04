package typeinfo.toys;

interface HashBatteries{}
interface Waterproof{}
interface Shoots {}

class Toy {
    Toy() {

    }

    Toy(int i) {

    }
}

class FancyToy extends Toy implements HashBatteries,Waterproof,Shoots{
    public FancyToy() {
        super(1);
    }
}
public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
        "is interface? [" +cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Cann't find  FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object object = null;
        try {
            object = up.newInstance();
        } catch (IllegalAccessException e) {
            System.out.println("Cannot instantiate");
        } catch (InstantiationException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(object.getClass());
    }
}
