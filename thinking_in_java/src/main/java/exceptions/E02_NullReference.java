package exceptions;

/**
 * Created by LiuHua on 18-4-8.
 */
public class E02_NullReference {
    public static void main(String[] args) {
        String s = null;
        //s.toString();
        try {
            s.toString();
        } catch (Exception e) {
            System.out.println("Caught exception " + e);
        }
    }
}
