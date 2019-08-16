package io;

import java.io.Serializable;

/**
 * @author lh
 * A serializable class
 */
public class Alien extends Test {
    public Alien(int a1) {
        super("1");
        this.a = a1;
    }

    // public Alien() {
    //     super("1");
    // }

    public int a;

}
