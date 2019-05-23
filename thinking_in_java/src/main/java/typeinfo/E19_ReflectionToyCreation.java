package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * In ToyTest.java, use reflection to create a
 * Toy object using the nondefault constructor.
 **/
class SuperToy extends FancierToy {
   int IQ;

   public SuperToy(int IQ) {
      this.IQ = IQ;
   }

   @Override
   public String toString() {
      return "I'm a SuperToy. I'm smarter than you.";
   }
}
public class E19_ReflectionToyCreation {
   public static Toy makeToy(String toyName, int IQ) {
      try {
         Class<?> tClass = Class.forName(toyName);
         for (Constructor<?> ctor : tClass.getConstructors()) {
             // Look for a constructor with a single parameter:
            Class<?>[] params = ctor.getParameterTypes();
            if (params.length == 1) {
               if (params[0] == int.class) {
                  return (Toy) ctor.newInstance(new Object[]{IQ});
               }
            }
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
      return null;
   }

   public static void main(String[] args) {
      System.out.println(makeToy("typeinfo.SuperToy",150));
   }
}
