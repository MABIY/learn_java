package typeinfo1;

interface HashCPU{}

class FancierToy extends FancyToy implements HashCPU {

}
public class E02_ToyTest2 {
    static void printInfo(Class<?> cc) {
        System.out.println("Class name: " + cc.getName() + "" +
                "is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class<?> c = null;
        try {
            c = Class.forName("typeinfo1.FancierToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancierToy");
            System.exit(1);
        }
        printInfo(c);

        for (Class<?> face : c.getInterfaces()) {
            printInfo(face);
        }

        Class<?> up = c.getSuperclass();
        Object obj = null;

        try {
            obj = up.newInstance();
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
