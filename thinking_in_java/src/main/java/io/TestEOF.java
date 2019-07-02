package io;

import java.io.*;

/**
 * @author lh
 * Testing for end of file while reading a byte at a time.
 **/
public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("thinking_in_java/src/main/java/io/TestEOF.java")
                )
        );
        while (in.available() != 0) {
            System.out.print((char)in.readByte());
        }
    }
}
