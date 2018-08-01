package generics1;

import typeinfo1.pets.Cat;
import typeinfo1.pets.Dog;

import java.util.ArrayList;
import java.util.List;

public class CheckedList {
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1); // Quietly accepts a Cat
        //lhtd starting
    }
}
