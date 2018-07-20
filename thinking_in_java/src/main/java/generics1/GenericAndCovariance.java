package generics1;

import java.util.ArrayList;
import java.util.List;

public class GenericAndCovariance {
    public static void main(String[] args) {
        // Wildcard allow covariance:
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // Compile Error : can't add any type of object:
//        flist.add(new Apple());
//        flist.add(new Fruit());
//        flist.add(new Object());
        flist.add(null); // Legal but uninteresting
        // We know that is return at least fruit
        Fruit f = flist.get(0);
    }
}
