package exceptions;

/**
 * @author lh
 * Write code to generate and catch an
 * ArrayIndexOutOfBoundsException.
 **/
public class E03_ArrayIndexBounds {
    public static void main(String[] args) {
        char[] array = new char[10];
        try {
            array[10] = 'x';
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("e = " + e);
        }
    }
}
