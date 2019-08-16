package io;

import java.io.*;

import static net.lh.util.Print.print;

/**
 * @author lh
 * In Blips.java, copy the file and rename it to
 * BlipCheck.java and rename the clas blip2 to
 * BlipCheck (making it public and removing the
 * public scope from the class blips in the
 * process). Remove the //! marks in the file and
 * execute the program including the offending
 * lines. Next, comment out the default
 * constructor for BlipCheck. Run it and explain
 * why it works Note that after compiling, you
 * must execute the program with "java Blips"
 * because the main() method is still in class Blips
 */
class Blip11 implements Externalizable {
    public Blip11() {
        print("Blip11 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip11.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip11.readExternal");

    }
}

public class E28_BlipCheck implements Externalizable {
    // public E28_BlipCheck() {
    //     print("BlipCheck Constructor");
    // }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        print("BlipCheck.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("BlipCheck.readExternal");
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Blips22.main(args);
    }
}

class Blips22 {

    public static final String BLIPS_OUT = "Blips.out";

    // Throw exceptions to console:
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        print("Constructing object:");
        Blip11 b1 = new Blip11();
        E28_BlipCheck b2 = new E28_BlipCheck();
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream(BLIPS_OUT)
        );
        print("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Blips.out")
        );
        print("Recovering b1:");
        b1 = (Blip11) in.readObject();
        // OOPS! Throw an exception:
        b2 = (E28_BlipCheck) in.readObject();
    }
}
