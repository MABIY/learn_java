package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lh
 * Write a program that takes standard input and
 * capitalizes  all characters ,then puts the results
 * on standard output. redirect the contents of a file
 * int this program (the process of redirection will vary depending on your operating system)
 **/
public class E21_UpperCaseEcho {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            System.out.println(s.toUpperCase());
            // An empty line or Ctrl-Z terminates the program
        }
    }
}
