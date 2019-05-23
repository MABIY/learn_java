package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Modify the regular expression in ShowMehtods.java to
 * also strip off the keywords native and final.
 * (Hint: Use the OR operator '|')
 **/
public class E17_ShowMethods2 {
    private static String usage ="" +
            "Usage: \n" +
            "E17_ShowMethod2 qualified.cass.name\n" +
            "To show all emthod in class or:\n" +
            "E17_Showmethods2 qualified.class.name word\n" +
            "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("\\w+\\.|native\\s|final\\s");

    public static void main(String[] args) {
        args = new String[]{"typeinfo.E17_ShowMethods2"};
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
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            print("No such clas: " +e);
        }
    }
}
