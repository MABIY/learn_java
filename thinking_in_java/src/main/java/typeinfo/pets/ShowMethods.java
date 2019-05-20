package typeinfo.pets;

import innerclasses.Parcel2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static net.lh.util.Print.print;

/**
 * Using reflection to show all the methods of a class.
 * even if the methods are defined in  the base class.
 **/
public class ShowMethods {

    private static String usage = "usage:\n" +
            "ShowMethods qualified.class.name or:\n" +
            "To show all methods in class or:\n" +
            "ShowMethods qualified.cass.name word\n" +
            "To search for methods involving 'word'";
    private static Pattern p  = Pattern.compile("\\w+\\.");


    public static void main(String[] args) {
        args = new String[]{"typeinfo.pets.ShowMethods"};
        if (args.length < 1) {
            print(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    print(
                            p.matcher(method.toString()).replaceAll("")
                    );
                }
                System.out.println();
                for (Constructor ctor : ctors) {
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
                for (Constructor ctor : ctors) {
                    if (ctor.toString().contains(args[1])) {
                        print(
                                p.matcher(
                                        ctor.toString()
                                ).replaceAll("")
                        );
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
