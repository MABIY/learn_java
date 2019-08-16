package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author lh
 * Try to recover a serialized file without the
 * class of object that's stored in that file.
 */
public class ThawAlien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("X.file")
        );
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
