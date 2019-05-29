package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author lh
 **/
public class NeedCasting {
    public void f(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(args[0])
        );
        List shapes = (List<Widget>) in.readObject();
    }
}
