package generics;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 **/
public class GenericsAndConvariance {
    public static void main(String[] args) {
        // Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<>();
        // Compile Error: can't add any type of object:
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null); //Legal but uninteresting
        // We know that it returns at least Fruit:
        Fruit f = flist.get(0);
    }
}
