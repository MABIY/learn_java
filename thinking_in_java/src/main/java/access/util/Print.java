package access.util;

import java.io.PrintStream;

public class Print {
    public static int a;
    //Print with a newLine
    public static void print(Object obj) {
        System.out.println(obj);
    }

    //Print a newline by itself:
    public static void print() {
        System.out.println();
    }

    //Print with no line break
    public static void printnb(Object obj) {
        System.out.println(obj);
    }

    //The new Java SE5 printf() (from c)
    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format,args);
    }
}
