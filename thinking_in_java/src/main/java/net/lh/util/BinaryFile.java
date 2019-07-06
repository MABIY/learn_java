package net.lh.util;

import io.BufferedInputFile;

import java.io.*;

/**
 * @author lh
 * Utility for reading files in binary form
 **/
public class BinaryFile {
    public static byte[] read(File file) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(
                new FileInputStream(file),10
        );
        try {
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }

    public static byte[] read(String file) throws IOException {
        return read(new File(file).getAbsoluteFile());
    }

}
