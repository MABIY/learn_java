package io;

import java.io.*;

/**
 * @author lh
 * Modify BasicFileOutput.java so that it uses
 * LineNumberReader to keep track of the line
 * count. Note that it's much easier to just keep
 * track programmatically
 **/
public class E13_CountLines {
    static String file = "E13_CountLines.out";

    public static void main(String[] args) throws IOException {
        // LineNumberReader is inherited from
        LineNumberReader in = new LineNumberReader(
                new FileReader("thinking_in_java/src/main/java/io/E13_CountLines.java")
        );
        PrintWriter out = new PrintWriter(file);
        String s;
        while ((s = in.readLine()) != null) {
            out.println(in.getLineNumber() + ": " + s);
        }
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }

}
