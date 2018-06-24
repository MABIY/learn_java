package typeinfo1;

public class E08_RecursiveClassPrint {
    static void printClasses(Class<?> c) {
        // getSuperclass() returns null on OBject;
        if (c == null) {
            return;
        }

        System.out.println(c.getName());

        //Produces the interfaces that this class
        //Implements
        for (Class<?> k : c.getInterfaces()) {
            System.out.println("Interface: " + k.getName());
            printClasses(k.getSuperclass());
        }
        printClasses(c.getSuperclass());
    }

    public static void main(String[] args) throws ClassNotFoundException {
        args = new String[]{"typeinfo1.Circle", "typeinfo1.FancyToy"};
        for (int i = 0; i < args.length; i++) {
            System.out.println("Displaying " + args[i]);
            printClasses(Class.forName(args[i]));
            if (i < args.length - 1) {
                System.out.println("==========");
            }
        }
    }
}
