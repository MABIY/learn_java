package io;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

/**
 * @author lh
 * Modify Exercise 7 so that the name of the file
 * you read is provided as a command-line argument.
 **/
public class E08_CommandLine {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java E08_Command");
            return;
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious(); ) {
            System.out.println(it.previous());
        }
    }
}
