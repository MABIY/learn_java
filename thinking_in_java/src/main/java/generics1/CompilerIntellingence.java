package generics1;

import java.util.Arrays;
import java.util.List;

public class CompilerIntellingence {
    public static void main(String[] args) {
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple) flist.get(0); //No warning
        System.out.println(flist.contains(new Apple())); // Arguemnt is 'Object'
        System.out.println(flist.indexOf(new Apple())); // Argument is 'Object'
    }
}
