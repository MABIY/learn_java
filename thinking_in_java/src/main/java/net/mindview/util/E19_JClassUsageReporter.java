package net.mindview.util;
//: strings/E19_JClassUsageReporter.java
// {Args: E19_JClassUsageReporter.java}

import innerclasses.ClassInInterface;
import strings.E17_JCommentExtractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*************Exercise 19*****************
 * Build on Exercises 17 and 18 to write a program
 * that examines java source code and produces all
 * class name used in a particular program.
******************************/
public class E19_JClassUsageReporter {
    private static final String Identifier =
            "[$A-Za-z_][$A-Za-z_0-9]*";
    private static final String classOrInterfaceType =
            Identifier + "(?:\\." + Identifier + ")*";
    static final String CU_REP_REGEX = "class\\s+" + classOrInterfaceType + "|new\\s+" + classOrInterfaceType;

    public static void main(String[] args) {
        args = new String[]{"thinking_in_java/src/main/java/net/mindview/util/E19_JClassUsageReporter.java"};
        if (args.length < 1) {
            System.out.println("" +
                    "Usage: java E19_JClassUsageReporter file");
            System.exit(0);
        }
        String src = TextFile.read(args[0]);
        // Prune away comments ...
        src = src.replaceAll(E17_JCommentExtractor.CMNT_EXT_REGEX, "");
        src = src.replaceAll(E18_JStringExtractor.STR_EXT_REGEX, "");
        Pattern p = Pattern.compile(CU_REP_REGEX);
        Matcher m = p.matcher(src);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
