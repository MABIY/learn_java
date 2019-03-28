package object;

import java.util.Date;

/**
 * You can even insert a list:
 * <ol>
 *     <li>Item one</li>
 *     <li>Item two</li>
 *     <li>Item three</li>
 * </ol>
 * Another test list
 * <ol>
 *     <li>One</li>
 *     <li>Two</li>
 *     <li>Three</li>
 * </ol>
 **/
public class Documentation4 {
    /**
     *Let's try a public field list
     * <ol>
     *     <li>One</li>
     *     <li>Two</li>
     *     <li>Three</li>
     * </ol>
     */
    public int i = 2;

    /**
     * A private field list (-private to see)
     * <ol>
     *     <li>One</li>
     *     <li>Two</li>
     *     <li>Three</li>
     * </ol>
     */
    private int j = 3;

    /**
     * Another list can be inserted here to help explain the
     * following method call
     * <ol>
     *     <li>One</li>
     *     <li>Two</li>
     *     <li>Three</li>
     * </ol>
     * but may be formatted differently in Method Summary
     * @param args test
     */
    public static void main(String[] args) {
        /**
         * Let's try another test list here
         * <ol>
         *     <li>One</li>
         *     <li>Two</li>
         *     <li>Three</li>
         * </ol>
         */
        Date d = new Date();
        System.out.println("d = " + d);
    }
}
