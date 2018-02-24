package io.xfiles;

import java.io.*;

public class ThawAlien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(new File("x.out"))
        );
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
