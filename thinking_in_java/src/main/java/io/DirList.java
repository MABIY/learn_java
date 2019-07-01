package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author lh
 * Display a directory listing using regular expression.
 * {Args: "D.*\.java"}
 **/
public class DirList {
    public static void main(String[] args) {
        args = new String[]{"D.*\\.java"};
        File path = new File("thinking_in_java/src/main/java/io");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }

}

class DirFilter implements FilenameFilter{
    private Pattern pattern;

    public DirFilter(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
