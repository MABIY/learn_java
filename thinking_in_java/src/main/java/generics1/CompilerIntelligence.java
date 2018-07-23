package generics1;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple()); //No warning
        flist.contains(new Apple());  // Argument is 'Object'
        flist.indexOf(new Apple()); //Argument is 'Object'
    }

}
