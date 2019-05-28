package generics;

/**
 * @author lh
 * Demonstrate array covariance using Numbers and Integers.
 **/
public class E26_CovariantArrays2 {
    public static void main(String[] args) {
        Number[] nums = new Integer[10];
        nums[0] = Integer.valueOf(1);
        try {
            nums[1] = new Float(1.0); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            nums[2] = Byte.valueOf((byte) 1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
