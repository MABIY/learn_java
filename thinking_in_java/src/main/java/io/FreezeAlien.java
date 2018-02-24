package io;

import java.io.*;

public class FreezeAlien {
    public static void main(String[] args) throws IOException {
        ObjectOutput out = new ObjectOutputStream(
                new FileOutputStream("x.out")
        );
        Alien quenlek = new Alien();
        out.writeObject(quenlek);
    }
}
