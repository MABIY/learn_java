package net.mindview.util;

import java.util.Locale;
import java.util.Scanner;

/**
 * Create a class that contains int, long,float and double
 * and String fields, Create a constructor for this class
 * that takes a single String argument, And scans that
 * string into the various fields. Add a toString() method
 * and demonstrate that your class works correctly
 **/
class DataHolder2{
    private int i;
    private long l;
    private float f;
    private double d;
    private String s;

    public DataHolder2(String data) {
        Scanner stdin = new Scanner(data);
        stdin.useLocale(Locale.US);
        i = stdin.nextInt();
        l = stdin.nextLong();
        f = stdin.nextFloat();
        d = stdin.nextDouble();
        s = stdin.next("\\w+");
    }

    @Override
    public String toString() {
        return "E20_Scanner{" +
                "i=" + i +
                ", l=" + l +
                ", f=" + f +
                ", d=" + d +
                ", s='" + s + '\'' +
                '}';
    }
}
public class E20_Scanner {
    public static void main(String[] args) {
        DataHolder2 dh = new DataHolder2("1 10000000000000 1.1 1e55 Howdy Hi");
        System.out.println(dh.toString());
    }
}
