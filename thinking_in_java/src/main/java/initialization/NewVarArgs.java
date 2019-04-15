package initialization;

import com.sun.org.apache.bcel.internal.generic.FALOAD;

/**
 * @author lh
 **/
public class NewVarArgs {
    static void printArray(Object... args) {
        for (Object obj : args) {
            System.out.println(obj + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Can take individual elements
        printArray(new Integer(47), new Float(3.14), new Double(11.11));
        printArray(47,3.14f,11.11);
        printArray("one","two","three");
        printArray(new A(),new A(),new A());
        // or an array:
        printArray((Object[])new Integer[]{1,2,3,4});
        printArray(); // Empty list is ok
    }
}
