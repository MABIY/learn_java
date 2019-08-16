package io;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Demonstrates the "transient" keyword
 **/
public class Logon  implements Serializable {
    private static final long serialVersionUID = -1066605574765306005L;
    public static final String LOGON_OUT = "Logon.out";
    private Date date = new Date();
    private String userName;
    private transient String password;

    public Logon(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Logon a = new Logon("Hulk", "myLittlePony");
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream(LOGON_OUT)
        );
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1); // Delay
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(LOGON_OUT)
        );
        print("Recovering object at " + new Date());
        a = (Logon) in.readObject();
        print("Logon a = " + a);
    }
}
