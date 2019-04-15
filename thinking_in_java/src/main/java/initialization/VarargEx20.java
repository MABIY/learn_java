package initialization;

/**
 * @author lh
 * Create a mian() that uses varargs instead of the ordinary main syntax,print
 * all the elements in the resulting args array. Test it with various numbers of
 * command-line arguments
 **/
public class VarargEx20 {
    public static void main(String... args) {
        for (String s : args) {
            System.out.println(s + " ");
        }
        System.out.println();
    }
}
