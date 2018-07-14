package generics1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ClassAsFactory1<T>{
    Class<T> kind;

    public ClassAsFactory1(Class<T> kind) {
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
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
public class E22_InstantiateGenericType2 {
}
