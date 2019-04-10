package operators;

/**
 * @author lh
 **/
public class Overflow {
    public static void main(String[] args) {
        int big = Integer.MAX_VALUE;
        System.out.println(Integer.toBinaryString(big));
        System.out.println("big = " + big);
        int bigger = big * 8;
        System.out.println(Integer.toBinaryString(bigger));
        System.out.println("bigger =  " + bigger);
    }
}
