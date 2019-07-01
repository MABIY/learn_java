package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

import static net.lh.util.Print.print;

/**
 * @author lh
 * {Args: "E0[12]_.*\.java"}
 * Modify DirList.java (or one of its variants) so
 * that it sums up the file sizes of  the selected
 * files
 **/
public class E03_DirSize {
    public static void main(String[] args) {
        String[] args1 = new String[]{"E0[12]_.*\\.java"};
        File path = new File("thinking_in_java/src/main/java/io");
        String[] list;
        if (args1.length == 0) {
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args1[0]);

                @Override
                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        long total = 0;
        long fs;
        for (String dirItem : list) {
            fs = new File(path, dirItem).length();
            print(dirItem + ", " +fs + " byte(s)");
            total += fs;
        }
        print("----------");
        print(list.length + " files(s), " + total + " bytes");
    }
}
