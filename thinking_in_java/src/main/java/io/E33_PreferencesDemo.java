package io;

import java.util.Scanner;
import java.util.prefs.Preferences;

import static net.lh.util.Print.print;

/**
 * @author lh
 * {RunByHand}
 * ******************************
 * Write a program that displays the current value
 * of a directory called "base directory" and
 * prompts you for a new value. Use the Preferences
 * API the store the value
 **/
public class E33_PreferencesDemo {

    public static final String BASE_DIRECTORY = "base directory";

    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(E33_PreferencesDemo.class);
        String directory = prefs.get(BASE_DIRECTORY, "Not defined");
        print("directory: " + directory);
        Scanner sc = new Scanner(System.in);
        print("Enter a new directory: ");
        directory = sc.nextLine();
        prefs.put(BASE_DIRECTORY,directory);
        print("\ndirectory: " +directory);
    }
}
