package exceptions;

/**
 * Created by LiuHua on 18-4-8.
 */
public class E01_SimpleException {
    public E01_SimpleException() {
    }

    public static void main(String[] args) {
        try {
            throw new Exception("An exception in main");
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }finally {
            System.out.println("In finally clause");
        }
    }
}
