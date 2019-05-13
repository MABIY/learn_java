package exceptions;

/**
 * @author lh
 * Modify Exercise 3 to convert the exception to a
 * RuntimeException
 **/
public class E27_RuntimeArrayIndexBounds {
    public static void main(String[] args) {
        char[] array = new char[10];
        try {
            array[10] = 'x';
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }
}
