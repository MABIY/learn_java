package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author lh
 **/
public class FormattedMemoryInput {
    public static void main(String[] args) {
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read(
                                    "thinking_in_java/src/main/java/io/FormattedMemoryInput.java"
                            ).getBytes()
                    )
            );
            while (true) {
                System.out.print((char) in.readByte());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
