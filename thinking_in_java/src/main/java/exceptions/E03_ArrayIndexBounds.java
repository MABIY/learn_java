package exceptions;

/**
 * Created by LiuHua on 18-4-8.
 */
public class E03_ArrayIndexBounds {
    public static void main(String[] args) {
        char[] array = new char[10];
        try {
            for (char a : array) {
                System.out.println(a);
            }
            array[10] = 'x';
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("e= " + e);
        }
    }
}
