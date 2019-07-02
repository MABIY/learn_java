package io;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * @author lh
 * {Args: E10_FindWords.java import pubic }
 * Modify Exercise 8 to take additioonal command-line
 * arguments of words to find in the file. Print
 * all lines in which any of the words match.
 **/
public class E10_FindWords {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java E10_FindWords file words");
            return;
        }
        Set<String> words = new HashSet<>();
        for (int i = 0; i < args.length; i++) {
            words.add(args[i]);
        }
        List<String> list = E07_FileIntoList.read(args[0]);
        for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();) {
            String candidate = it.previous();
            for (String word : words) {
                if (candidate.contains(word)) {
                    System.out.println(candidate);
                    break;
                }
            }
        }

    }
}
