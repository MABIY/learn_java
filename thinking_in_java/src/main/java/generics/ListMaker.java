package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 **/
public class ListMaker<T> {
    List<T>  create() {
        return new ArrayList<T>();
    }

    public static void main(String[] args) {
        ListMaker<String> stringMarker = new ListMaker<>();
        List<String> stringList = stringMarker.create();
    }
}
