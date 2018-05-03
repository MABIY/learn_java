package arrays;

import lh.com.util.CountingGenerator;

public class E13_StringFill {
    public static void main(String[] args) {
        String s = new CountingGenerator.String(15).next();
        System.out.println(s);
    }
}
