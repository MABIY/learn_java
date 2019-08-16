package io;

import java.io.*;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Reconstructing an externalizable object.
 */
public class Blip3 implements Externalizable {
    public int i;
    public String s; // No initialization

    public Blip3() {
        print("Blip3 Constructor");
        //s , i not initialized
    }

    public Blip3(String s, int i) {
        print("Blip3(String x, int a)");
        this.i = i;
        this.s = s;
        // s & i initialized only in non-default constructor
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip3.writeExternal");
        // you must do this:
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip3.readExternal");
        // you must do this:
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        print("Constructing objects:");
        Blip3 b3 = new Blip3("A String", 47);
        print(b3);
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream("Blip3.out")
        );
        print("Saving Object:");
        o.writeObject(b3);
        o.close();
        // Now get it back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Blip3.out")
        );
        print("Recovering b3:");
        b3 = (Blip3) in.readObject();
        print(b3);

    }
}
