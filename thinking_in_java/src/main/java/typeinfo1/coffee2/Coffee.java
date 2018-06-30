package typeinfo1.coffee2;


import typeinfo1.factory.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Coffee {
    private static int counter = 0;
    private int id = counter++;

    private static List<Factory<? extends Coffee>> coffeeFacotries = Arrays.asList();

    private static Random rand = new Random(47);

    public static Coffee createRandom() {
        int n = rand.nextInt(coffeeFacotries.size());
        return coffeeFacotries.get(n).create();
    }

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

}
