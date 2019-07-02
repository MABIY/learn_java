package io;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

/**
 * @author lh
 * Modify Exercise 8 to force all the lines in
 * the LinkedList to uppercase and send the results
 * to System.out.
 **/
public class E09_UpperCase {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java E09_UpperCase file");
            return;
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();) {
            System.out.println(it.previous().toUpperCase());
        }
    }
}
