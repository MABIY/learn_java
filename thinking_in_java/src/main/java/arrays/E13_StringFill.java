package arrays;

import net.lh.util.CountingGenerator;

/**
 * @author lh
 * Fill a String using CountingGenerator.Character.
 **/
public class E13_StringFill {
    public static void main(String[] args) {
        String s = new CountingGenerator.String(15).next();
        System.out.println(s);
    }
}
