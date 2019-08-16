package io;

import java.io.*;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Create a Serializable class containing a reference to an
 * object of a second Serializable class, create an instance
 * of your class, serialize it to disk, then restore it and
 * verify that the process worked correctly
 */

class Thing1 implements Serializable{
    private Thing2 next;

    public Thing1(int id) {
        next = new Thing2(id);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Thing1(Thing2");
        result.append(next);
        result.append("))");
        return result.toString();
    }
}

class Thing2 implements Serializable {
    private int id;

    public Thing2(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}

public class E27_ObjectSerialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Thing1 t1 = new Thing1(1);
        print("t1 = " + t1);
        String storeFile = "thing1.out";
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(storeFile)
        );
        out.writeObject("Thing1 storage\n");
        out.writeObject(t1);
        out.close(); // Also flushes output
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(storeFile)
        );
        String s = (String) in.readObject();
        Thing1 t2 = (Thing1) in.readObject();
        print(s + "t2 = " + t2);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Thing1 storage\n");
        out2.writeObject(t1);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(bout.toByteArray())
        );
        s = (String) in2.readObject();
        Thing1 t3 = (Thing1) in2.readObject();
        print(s + "t3 = " +t3);
    }
}

