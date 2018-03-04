package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
    private static String usage =
            "need input arugment";
    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        int lines = 0;
        try {
            Class<?> c = Class.forName(ShowMethods.class.getName() + "");
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            for (Method method : methods) {
                System.out.println(
                        p.matcher(method.toString()).replaceAll(""));
            }
            for (Constructor ctor : ctors) {
                System.out.println(
                        p.matcher(ctor.toString()).replaceAll("")
                );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
