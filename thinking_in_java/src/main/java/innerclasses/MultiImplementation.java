package innerclasses;

/**
 * @author lh
 * With concrete or abstract class, inner
 * clases are the only way to -roduce the effect
 * of "multiple implementation inheritance."
 **/
class D{}
abstract class E{}
class Z extends D{
    E makeE() {
        return new E(){

        };
    }
}
public class MultiImplementation {
    static void takesD(D d) {}

    static void takesE(E e) {}

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
