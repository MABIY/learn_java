package generics;

import java.lang.reflect.Constructor;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Use a type tag along with reflection to create
 * a method that uses the argument version of
 * new Instance() to create an object a class
 * with a constructor that has arguments.
 **/
class ClassAsFactory22<T> {
    Class<T> kind;

    public ClassAsFactory22(Class<T> kind) {
        this.kind = kind;
    }

    public T create(int arg) {
        try {
            // Technique 1 (verbose)
            for (Constructor<?> ctor : kind.getConstructors()) {
                // Look for a constructor with a single parameter:
                Class<?>[] params = ctor.getParameterTypes();
                if (params.length == 1) {
                    if (params[0] == int.class) {
                        return kind.cast(ctor.newInstance(arg));
                    }
                }
            }
            // Technique 2 (direct)
            //  Constructor<T> ct = kind.getConstructor(int.class);
            // ct.newInstance(arg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}

public class E22_InstantiateGenericType2 {
    public static void main(String[] args) {
        ClassAsFactory22<Employee1> fe = new ClassAsFactory22<>(Employee1.class);
        Employee1 emp = fe.create(1);
        if (emp == null) {
            print("Emloyee cannot be instantiated!");
        }
        ClassAsFactory22<Integer> fi = new ClassAsFactory22<>(Integer.class);
        Integer i = fi.create(0);
        if (i == null) {
            print("Integer cannot be instaniated!");
        }
    }
}
