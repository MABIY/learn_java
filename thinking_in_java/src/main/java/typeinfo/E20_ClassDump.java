package typeinfo;

import static net.lh.util.Print.print;

/**
 * Look up the interface for java.lang.Class in
 * the JDK documentation from java.sun.com.
 * Write a program that takes the name of a class
 * as a command-line argument, then uses the
 * Class methods to dump all the information
 * available for that class. Test your program
 * with a standard library class and a class you create.
 **/
interface BB{
    public static final String a = "1";
    public static void test() {}

}

class BB_Sub implements BB {
    public static String bb_a = "fdsaf";
    public String bb_c = "cc";
    public static void tt() {

    }
    public void pp() {

    }
}
class A1{
    public Object a(){
        return null;
    }
}
class B1 extends A1{
    @Override
    public String a() {
        return null;
    }
}
public class E20_ClassDump extends BB_Sub{

    public static String b;
    public String c;
    public static void display(String msg, Object[] vals) {
        print(msg);
        for (Object val : vals) {
            print("  " + val);
        }
    }

    public static void classInfo(Class<?> c) {
        print("c.getName(): " + c.getName());
        print("c.getPackage(): " + c.getPackage());
        print("c.getSuperclass(): " + c.getSuperclass());
        // This produces all the classes declared as members:
        display("c.getDeclaredMethods()", c.getDeclaredMethods());
        display("c.getMethods()", c.getMethods());
        display("c.getDeclaredConstructors()", c.getDeclaredConstructors());
        display("c.getConstructors()", c.getConstructors());
        display("c.getDeclaredFields()", c.getDeclaredFields());
        display("c.getFields()", c.getFields());
        if (c.getSuperclass() != null) {
            print("Base class: --------");
            classInfo(c.getSuperclass());
        }

        print("End of " + c.getName());
    }

    public static void main(String[] args) throws ClassNotFoundException {
        args = new String[]{"typeinfo.E20_ClassDump"};
        for (String arg : args) {
            classInfo(Class.forName(arg));

        }
    }
}
