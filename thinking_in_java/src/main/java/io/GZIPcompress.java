package io;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author lh
 */
public class GZIPcompress {

    public static String name = "test.gz";

    public static void main(String[] args) throws IOException {
        args = new String[]{"/home/lh/project/learn_java/thinking_in_java/src/main/java/io/GZIPcompress.java"};
        if (args.length == 0) {
            System.out.println(
                    "Usage: \n GZIPcompress file\n" +
                            "\tUses GZIP compression to compress" +
                            "the file to test.gz"
            );
            System.exit(1);
        }

        BufferedReader in = new BufferedReader(
                new FileReader(args[0])
        );
        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(
                        new FileOutputStream("test.gz")
                )
        );
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1) {
            out.write(c);
        }
        in.close();
        out.close();
        System.out.println("Reading file");
        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(new GZIPInputStream(
                        new FileInputStream(name)
                ))
        );
        String s;
        while ((s = in2.readLine()) != null) {
            System.out.println(s);
        }
    }
}
