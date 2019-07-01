package io;

import net.mindview.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lh
 * {Args: java E01_SearchWords}
 * Modify DirList.java (or one of its variants) so
 * that the FilenameFilter opens and reads each file
 * (using the net.mindview.util.TextFile utility) and
 * accepts the file based on whether any of the trailing
 * arguments on the command line exist in that file.
 **/
public class E01_SearchWords {
    public static void main(String[] args) {
        File path = new File("thinking_in_java/src/main/java/io");
        final  String[] args1 = new String[]{"java", "E01_SearchWords"};
        String[] list;
        if (args1.length == 0) {
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {
                private String ext = args1[0].toLowerCase();

                @Override
                public boolean accept(File dir, String name) {
                    // Only analyze source files with the specified
                    // extension (given as the first command line argument)
                    if (name.toLowerCase().endsWith(ext)) {
                        // Only filter upon file extension?
                        if (args1.length == 1) {
                            return true;
                        }
                        Set<String> words = new HashSet<>(
                                new TextFile(new File(dir, name).getAbsolutePath())
                        );
                        for (int i = 1; i < args1.length; i++) {
                            if (words.contains(args1[i])) {
                                return true;
                            }
                        }
                    }
                    return false;

                }
            });
        }

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
