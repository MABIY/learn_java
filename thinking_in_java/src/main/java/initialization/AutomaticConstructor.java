package initialization;

/**
 * @author lh
 * Create a class without a constructor,and then create an object of that
 * class in main() to verify that the default constructor is automatically
 * synthesized
 **/
class Aso{
    void bark() {
        System.out.println("woof");
    }
}
/**
 * @author lh
 */
public class AutomaticConstructor {
    public static void main(String[] args) {
        Aso a = new Aso();
        a.bark();
    }
}
