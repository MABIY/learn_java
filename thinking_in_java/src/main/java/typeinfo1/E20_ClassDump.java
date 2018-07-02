package typeinfo1;

// The solution is a much-modified version of ShowMethod.java
public class E20_ClassDump {
    public static void display(String msg, Object[] vals) {
        System.out.println(msg);
        for (Object val : vals) {
            System.out.println("  " + val);
        }
    }

    public static void classInfo(Class<?> c) {
        System.out.println("c.getName(): " + c.getName());
        System.out.println("c.getPackge(): " + c.getPackage());
        System.out.println("c.getSuperclass()" + c.getSuperclass());
        // This produces all the classes declared as members:
        display("c.getDeclaredClasses()", c.getDeclaredClasses());
        display("c.getClasses()", c.getClasses()); // 不包含父接口的 class member
        display("c.getInterfaces()",c.getInterfaces());
        // The "Declared" version includes all
        // versions, not just public:
        display("c.getDeclaredmethods()",c.getDeclaredMethods());
        display("c.getMethods()", c.getMethods());
        display("c.getConstructors()", c.getConstructors());
        display("c.getDeclaredConstructors()", c.getDeclaredConstructors());
        display("c.getDeclaredFields()", c.getDeclaredFields());
        display("c.getFields()", c.getFields());
        if (c.getSuperclass() != null) {
            System.out.println("Base class: ----------");
            classInfo(c.getSuperclass());
        }
        System.out.println("End of + c.getName()");

    }

    public static void main(String[] args) throws ClassNotFoundException {
        args = new String[]{"typeinfo1.Test"};
        for (String arg : args) {
            classInfo(Class.forName(arg));
        }
    }
}
