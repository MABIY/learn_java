package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static net.lh.util.Print.print;

/**
 * make ShowMethods a non-public class and verify that
 * the synthesized default constructor no longer appears in
 * the output
 **/
interface AFather{
    static void a_father_static(){

        System.out.println("c_static_method()");
    }

    void a_father();
}

interface A extends AFather{
    public static void t(){};

    void p();
}
 class C{
    public static void c_static_method() {
    }
    public void c_method() {

    }
}
class E18_ShowMethods3 extends C implements A{
    private static String usage =
            "usage:\n" +
                    "E18_ShowMethod3 qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "E18_ShowMethods3 qualified.class.name word\n" +
                    "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        E18_ShowMethods3 e18_showMethods3 = new E18_ShowMethods3();
        args = new String[]{"typeinfo.A"};
        if (args.length < 1) {
            print(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor<?>[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    print(
                            p.matcher(method.toString()).replaceAll("")
                    );
                }
                for (Constructor<?> ctor : ctors) {
                    print(p.matcher(ctor.toString()).replaceAll(""));
                }
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().contains(args[1])) {
                        print(
                                p.matcher(method.toString()).replaceAll("")
                        );
                        lines++;
                    }
                }
                for (Constructor<?> ctor : ctors) {
                    if (ctor.toString().contains(args[1])) {
                        print(
                                p.matcher(ctor.toString()).replaceAll("")
                        );
                        lines++;
                    }
                }

            }
        } catch (ClassNotFoundException e) {
            print("No such class: " + e);
        }
    }

    @Override
    public void a_father() {

    }

    @Override
    public void p() {

    }
}
