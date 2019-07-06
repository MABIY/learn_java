package net.lh.util;

import java.io.PrintWriter;

/**
 * @author lh
 * Turn System out into PrintWriter.
 **/
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello, world");
    }
}
