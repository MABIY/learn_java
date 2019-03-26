package object;

import java.util.Date;

/**
 * The first Thinking in java example program.
 * Displays a string and today's date.
 *
 * @author lh
 * @author www.lh.com
 * @version 4.0
 */
public class HelloDate {
    /** Entry point to class & application.
     * @param args array of string arguments
     * @throws exceptions no exceptions thrown
     */
    public static void main(String[] args) {
        System.out.println("Hello, it's");
        System.out.println(new Date());
    }
}
