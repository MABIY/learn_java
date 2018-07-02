package typeinfo1;

// In ToyTest.java use reflection to create a
// Toy object using the nondefault constructor
//

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class SuperToy extends FancierToy {
    int IQ;

    public SuperToy(int intelligence) {
        this.IQ = IQ;
    }

    @Override
    public String toString() {
        return "I'm a SuperToy. I'm smarter than you";
    }
}

public class E19_ReflectionToyCreation {
    public static Toy makeToy(String toyName, int IQ) {
        try {
            Class<?> tClass = Class.forName(toyName);
            for (Constructor<?> ctor : tClass.getConstructors()) {
                // Look for a constructor with a single parameter:
                Class<?>[] params = ctor.getParameterTypes();
                if (params[0] == int.class) {
                    return (Toy) ctor.newInstance(new Object[]{IQ});
                }

            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(makeToy("typeinfo1.SuperToy", 150));
    }
}
