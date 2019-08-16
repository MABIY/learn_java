package io;

import java.io.Serializable;

/**
 * @author lh
 * A serializable class
 */
public class Alien extends Test {
    public Alien(int a1) {
        this.a = a1;
    }

    Alien() {
        System.out.println("test");
    }

    public int a;

}
