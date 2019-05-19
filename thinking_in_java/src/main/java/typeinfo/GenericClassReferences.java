package typeinfo;

/**
 * @author lh
 **/
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class; // Same thing
        // genericIntClass = double.class; illegal
    }
}
