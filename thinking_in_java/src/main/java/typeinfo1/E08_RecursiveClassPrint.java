package typeinfo1;

public class E08_RecursiveClassPrint {
    static void printClasses(Class<?> c) {
        // getSuperclass() return null on object:
        if (c == null) {
            return;
        }
        System.out.println(c.getName());
        // Produces the interfaces that this class
        // implements
        for (Class<?> k : c.getInterfaces()) {
            System.out.println("Interface: " + k.getName());
            printClasses(k.getSuperclass());
        }
        printClasses(c.getSuperclass());
    }

    public static void main(String[] args) throws ClassNotFoundException {
        args = new String[]{Circle.class.getName(), FancyToy.class.getName()};
        for (int i = 0; i < args.length; i++) {
            System.out.println("Displaying " + args[i]);
            printClasses(Class.forName(args[i]));
            if (i < args.length - 1) {
                System.out.println("======");
            }
        }
    }
}
