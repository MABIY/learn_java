package net.mindview.util;

//: strings/E18_JString.java
// {Args: E18_JStringExtractor.java}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/******************************
 * Write a program that reads a Java source-code file
 * and displays all the string literals in the code
 * (provide the file name on the command line).
******************************/
public class E18_JStringExtractor {
    static final String STR_EXT_REGEX =
            "\"(?:[^\"\\\\\\n\\r]|(?:\\\\(?:[untbrf\\\\'\"]|[0-9A-Fa-f]{4}|[0-7]{1,2}|[0-3][0-7]{2})))*\"";

    public static void main(String[] args) {
        args = new String[]{"thinking_in_java/src/main/java/net/mindview/util/E18_JStringExtractor.java"};
        if (args.length < 1) {
            System.out.println("Usage: java E18_JStringExtractor file)");
            System.exit(0);
        }

        String src = TextFile.read(args[0]);
        Pattern p = Pattern.compile(STR_EXT_REGEX);
        Matcher m = p.matcher(src);
        while (m.find()) {
            System.out.println(m.group().substring(1, m.group().length() - 1));
        }
        // "This is NOT a string but a comment!"
        String dummy = "\u003f\u003f\n\060\607";
    }
}
