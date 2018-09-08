package object;


// object/Documentation4.java

import java.util.Date;

/**
 * You can even insert a list:
 * <ol>
 * <li> Item one
 * <li> Item two
 * <li> Item three
 * </ol>



 * Another test list
 * <ol>
 * <li> One
 * <li> Two
 * <li> Three
 * </ol>
 */

public class Documentation4 {
    /** Let's try a public field list
     * <o1>
     *     <li>
     *         One
     *     </li>
     *     <li>
     *         Two
     *     </li>
     *     <li>
     *         Three
     *     </li>
     *
     * </o1>
     */
    public int i = 2;

    /**
     * A private field list(-private to see)
     * <ol>
     *     <li>
     *         One
     *     </li>
     *     <li>
     *         Two
     *     </li>
     *     <li>
     *         Three
     *     </li>
     * </ol>
     */
    private int j = 3;

    /**
     * Another list can be inserted here to help explain the
     * follwing method call
     * <ol>
     *     <li>
     *         One
     *     </li>
     *     <li>
     *         Two
     *     </li>
     *     <li>
     *         Three
     *     </li>
     * </ol><br>
     *     but may formatted differently in Method Summary
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Let's try another test list here
         * <ol>
         *     <li>
         *         One
         *     </li>
         *     <li>
         *         Two
         *     </li>
         *     <li>
         *         Three
         *     </li>
         * </ol>
         */
        Date d  = new Date();
        System.out.println("d = " + d);
    }
}
