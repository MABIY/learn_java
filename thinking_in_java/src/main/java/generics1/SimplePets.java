package generics1;

import typeinfo1.Person;
import typeinfo1.pets.Pet;

import java.util.List;
import java.util.Map;

public class SimplePets {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
        //Reset of the code is the same
    }
}
