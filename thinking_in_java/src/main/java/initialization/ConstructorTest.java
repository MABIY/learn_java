package initialization;

/**
 * @author lh
 * Create a class containning an unitialized String reference.Demonstrate that
 * this reference is initialized by Java to null
 **/
class Tester{
    String s;
}
/**
 * @author lh
 */
public class ConstructorTest {
    public static void main(String[] args) {
        Tester t = new Tester();
        System.out.println(t.s);
    }
}
