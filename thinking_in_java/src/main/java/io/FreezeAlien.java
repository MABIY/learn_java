package io;

import java.io.*;

/**
 * @author lh
 */
public class FreezeAlien {
    public static void main(String[] args) throws IOException {
        ObjectOutput out = new ObjectOutputStream(
                new FileOutputStream("X.file")
        );
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
}
