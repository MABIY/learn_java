package net.lh.util;

import com.sun.org.apache.regexp.internal.RE;

import java.io.PrintStream;

/**
 * @author lh
 * qualifiers,suing java SE5 static imports:
 **/
public class Print {
    // Print with newLine
    public static void print(Object obj) {
        System.out.println(obj);
    }

    /**
     * Print a newline by itself
     */
    public static void print() {
        System.out.println();
    }

    /**
     * print with no line break
     *
     * @param obj the obj
     */
    public static void printnb(Object obj) {
        System.out.println(obj);
    }

    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }
}
