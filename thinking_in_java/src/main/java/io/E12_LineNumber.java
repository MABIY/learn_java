package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ListIterator;

/**
 * @author lh
 * {Args: E12_LineNumber.java E12_LineNumber.out}
 * Modify Exercise 8 to also open a text file so
 * you can write text into it. Write the lines
 * in the LinkedList, along with line number (do not
 * attempt to use the "LineNumber" classes),out
 * to the file
 **/
public class E12_LineNumber {
    public static void main(String[] args) throws IOException {
        args = new String[]{"thinking_in_java/src/main/java/io/E12_LineNumber.java", "E12_LineNumber.out"};
        if (args.length != 2) {
            System.err.println(
                    "Usage: java EE12_LineNumber infile outfile"

            );
            return;
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter(args[1])
        ));
        // We need to count backwards:
        int line = list.size();
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious(); ) {
            out.println(line-- + ": " + it.previous());
        }
        out.close();
        System.out.println(BufferedInputFile.read("E12_LineNumber.out"));
    }
}
