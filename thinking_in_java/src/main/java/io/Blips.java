package io;

import java.io.*;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Simple use of Externalizable & a pitfall
 */
class Blip1 implements Externalizable {
    public Blip1() {
        print("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    Blip2() {
        print("Bilp2 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip2.readExternal");
    }
}
public class Blips {

    public static final String BLIPS_OUT = "Blips.out";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        print("Constructing object:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream(BLIPS_OUT)
        );
        print("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(BLIPS_OUT)
        );
        print("Recovering b1:");
        b1 = (Blip1) in.readObject();
        // OOPS! Throws an exception
        // print("Recovering b2:");
        // b2 = (Blip2) in.readObject();

    }
}
