package strings;

import net.mindview.util.TextFile;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lh
 * Modify JGrep.java to accept a directory name or a file
 * name as argument (if a directory is provided,search
 * should include all files in the directory).
 * Hint: you can generate a list of filenames with
 * File[] files = new File(".).listFiles();
 **/
public class E16_JGrep3 {
    public static void main(String[] args) {
        args = new String[]{
                "thinking_in_java/src/main/java/strings/E16_JGrep3.java",
                "java"
        };
        if (args.length < 2) {
            System.out.println(
                    "Usage: java E16_JGrep3 file regex"
            );
            System.exit(0);
        }
        File file = new File(args[0]);
        File[] files = null;
        if (file.isDirectory()) {
            files = file.listFiles();
        } else {
            files = new File[]{new File(args[0])};
        }
        Pattern p = Pattern.compile(args[1]);
        Matcher m = p.matcher("");
        for (File f : files) {
            System.out.println("-- File:" + f.getName() + "--");
            // Iterate through the line of the input file:
            int index =0;
            for (String line : new TextFile(f.getAbsolutePath())) {
                m.reset(line);
                while (m.find()) {
                    while (m.find()) {
                        System.out.println(index++ + ": " + m.group() + ": " + m.start());
                    }
                }
            }
        }
    }
}
