package generics;

import net.lh.util.New;
import typeinfo.Person;
import typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

/**
 * @author lh
 **/
public class LimitsOfInference {
    static void f(Map<Person, List<? extends Pet>> petPeople) {

    }

    public static void main(String[] args) {
        f(New.map());
    }
}
