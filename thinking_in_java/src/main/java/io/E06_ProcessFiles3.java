package io;


import net.lh.util.ProcessFiles;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lh
 * {Args: . 1/1/06}
 * Use ProcessFiles to find all the java
 * source-code files int a particular directory
 * subtree that have been modified after a
 * particular data
 **/
public class E06_ProcessFiles3 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: directory data(mm/dd/yyyy)");
            System.out.println("(OUtputs a listing of all java files in the given directory)" +
                    "\n that were last modified on or after the given data.");
            return;
        }
        final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyyMM/dd/yyyyMM/dd/yyyyMM/dd/yyyyMM/dd/yyyyMM/dd/yyyyMM/dd/yyyyMM/dd/yyyyMM/dd/yyyy");
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                Date modData = new Date(file.lastModified());
                try {
                    if (modData.after(sdf.parse(args[1]))) {
                        System.out.println(file);
                    }
                } catch (ParseException e) {
                    System.out.println(e.getErrorOffset());
                }
            }
        }, "java").start(args);
    }
}
