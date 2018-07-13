package generics1;

import java.lang.reflect.Constructor;

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
            }
        }
    }
}
public class E22_InstantiateGenericType2 {
}
