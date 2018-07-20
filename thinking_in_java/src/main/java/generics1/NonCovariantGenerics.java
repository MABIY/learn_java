package generics1;

import java.util.ArrayList;
import java.util.List;

public class NonCovariantGenerics {
    //Compile Error: incompotible sypes
    List<Fruit> flist = new ArrayList<>();
}
