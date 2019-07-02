package io;

import net.lh.util.Directory;

import java.io.File;

/**
 * @author lh
 * {Args: ".*\.java"} All java files
 * Use Directory.walk() to sum the sizes of all
 * files in a directory tree whose names match a
 * particular regular expression.
 **/
public class E04_DirSize2 {
    public static void main(String[] args) {
        Directory.TreeInfo ti;
        if (args.length == 0) {
            ti = Directory.walk("../object");
        } else {
            ti = Directory.walk("../object", args[0]);
        }
        long total = 0;
        for (File file : ti) {
            total += file.length();
        }
        System.out.println(ti.files.size() + " file(s), " + total + " byts");
    }
}
