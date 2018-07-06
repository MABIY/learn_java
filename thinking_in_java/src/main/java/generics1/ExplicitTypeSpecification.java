package generics1;

import typeinfo1.Person;
import typeinfo1.pets.Pet;

import java.util.List;
import java.util.Map;

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {

    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>>map());
    }
}
