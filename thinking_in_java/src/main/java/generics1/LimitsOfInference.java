package generics1;

import typeinfo1.Person;
import typeinfo1.pets.Pet;

import java.util.List;
import java.util.Map;

public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {
        System.out.println(petPeople);
    }

    public static void main(String[] args) {
        f(New.map());
    }
}
