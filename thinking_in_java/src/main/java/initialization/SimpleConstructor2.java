package initialization;

/**
 * @author lh
 * Constructors can have arguments
 **/
class Rock2{
    public Rock2(int i) {
        System.out.println("Rock " + i + " ");
    }
}
/**
 * @author lh
 */
public class SimpleConstructor2 {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            new Rock2(i);
        }
    }
}
