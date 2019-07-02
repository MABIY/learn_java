package io;

import net.lh.util.Directory;
import net.lh.util.ProcessFiles;

import java.io.File;
import java.io.IOException;

/**
 * @author lh
 * Modify ProcessFiles.java so that it matches a
 * regular experssion rather than a fixed
 * extension
 **/
public class E05_ProcessFiles2 {
    private ProcessFiles.Strategy strategy;
    private String regex;

    public E05_ProcessFiles2(ProcessFiles.Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0) {
                processDirectoryTree(new File("."));
            } else {
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory()) {
                        processDirectoryTree(fileArg);
                    } else {
                        if (arg.matches(regex)) {
                            strategy.process(fileArg.getCanonicalFile());
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsoluteFile(), regex)) {
            strategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        new E05_ProcessFiles2(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, ".*\\.java").start(args);
    }
}
