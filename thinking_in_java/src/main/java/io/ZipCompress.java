package io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Uses Zip compression ot compress any
 * number of files given on the command line.
 */
public class ZipCompress {
    public static void main(String[] args) throws IOException {
        args = new String[]{"ZipCompress.class"};
        String zipName = "test.zip";
        FileOutputStream f = new FileOutputStream(zipName);
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");
        // No corresponding getComment(), thought
        for (String arg : args) {
            print("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();
        // Checksum valid only after the file has been closed!
        print("Checksum: " + csum.getChecksum().getValue());
        // Now extract the files
        print("Reading file");
        FileInputStream fi = new FileInputStream(zipName);
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null) {
            print("Reading file " + ze);
            int x;
            while ((x = bis.read()) != -1) {
                System.out.write(x);
            }
        }
        if (args.length == 1) {
            bis.close();
            print("Checksum: " + csumi.getChecksum().getValue());
            // Alternative way to open and read Zip files:
            ZipFile zf = new ZipFile(zipName);
            Enumeration e = zf.entries();
            while (e.hasMoreElements()) {
                ZipEntry ze2 = (ZipEntry) e.nextElement();
                print("File: " + ze2);
                // .. and extract the data as before
            }

        }
    }
}

