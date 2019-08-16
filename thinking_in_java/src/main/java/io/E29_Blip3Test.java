package io;

import java.io.*;

import static net.lh.util.Print.print;

/**
 * @author lh
 * In Blip3.java comment out the two lines after
 * the phrases "you must do this:" and run the
 * program. Explain the result and why it differs
 * from when the two lines are in the program
 */
class Blip3B extends Blip3 {
    public Blip3B() {
    }

    public Blip3B(String s, int i) {
        super(s, i);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip3B.writeExternal");
        // You Must do this:
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip3B.readExternal");
        // You must do this:
        s = (String) in.readObject();
        i = in.readInt();
    }
}
public class E29_Blip3Test {

    public static final String BLIP_3_B_OUT = "Blip3B.out";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        print("Constructing objects:");
        Blip3B b3 = new Blip3B("A String ", 47);
        print(b3);
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream(BLIP_3_B_OUT)
        );
        print("Saving object:");
        o.writeObject(b3);
        o.close();
        // Now get it back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(BLIP_3_B_OUT)
        );
        print("Recovering b3:");
        b3 = (Blip3B) in.readObject();
        print(b3);
    }
}
