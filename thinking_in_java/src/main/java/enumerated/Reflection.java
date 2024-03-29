package enumerated;

import net.mindview.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Analyzing enums using reflection.
 */
enum Explore{HERE,THERE}
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        print("------- Analyzing " + enumClass + " -------");
        print("Integerfaces");
        for (Type t : enumClass.getGenericInterfaces()) {
            print(t);
        }
        print("Base: " +enumClass.getSuperclass());
        print("Methods: ");
        Set<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        print(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        print("Explore.containsAll(Enum)? " +
                exploreMethods.containsAll(enumMethods));
        print("Explore.removeAll(enum):*");
        exploreMethods.removeAll(enumMethods);
        print(exploreMethods);
        // Decompile the code for the enum
        OSExecute.command("javap -classpath /home/lh/project/learn_java/thinking_in_java/target/classes -c enumerated.Explore");
    }
}
