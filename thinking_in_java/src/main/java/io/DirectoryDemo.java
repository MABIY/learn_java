package io;

import net.lh.util.Directory;
import net.mindview.util.PPrint;

import java.io.File;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Sample use of Directory utilities.
 **/
public class DirectoryDemo {
    public static void main(String[] args) {
        // All directories:
        PPrint.pprint(Directory.walk(".").dirs);
        // All files beginning with 'T'
        for (File file : Directory.local(".", "T.*")) {
            print(file);
        }
        print("----------");
        // All java files beginning with 'T'
        for (File file : Directory.walk(".", "T.*\\.java")) {
            print(file);
        }
        // Class files containing "Z" or "z"
        for (File file : Directory.walk(".", ".*[Zz].*\\.class")) {
            print(file);
        }
    }
}
