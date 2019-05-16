package strings;

//: strings/E17_JCommentExtractor.java
// {Args: E17_JCommentExtractor.java}

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**************Exercise 17****************
 * Write a program that reads a java source-code file (you
 * provide the file name on the command line) and displays
 * all the comments
******************************/
public class E17_JCommentExtractor {
    public static final String CMNT_EXT_REGEX =
            "(?x)(?m)(?s) # Comments, Multiline & Dotall: ON\n" +
                    "/\\* # Match START OF THE COMMENT\n" +
                    "(.*?) # Match all chars\n" +
                    "\\*/ # Match END OF THE COMMENT\n" +
                    "| //(.*?)$ # OR MATCH C++ style comments\n";

    public static void main(String[] args) {
        args = new String[]{"thinking_in_java/src/main/java/strings/E17_JCommentExtractor.java"};
        if (args.length < 1) {
            System.out.println("" +
                    "Usage: java E17_JCommentExtractor file");
            System.exit(0);
        }
        String src = TextFile.read(args[0]);
        Pattern p = Pattern.compile(CMNT_EXT_REGEX);
        Matcher m = p.matcher(src);
        while (m.find()) {
            System.out.println(m.group(1)!=null?m.group(1): m.group(2));
        }
    }
}
