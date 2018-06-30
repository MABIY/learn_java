package typeinfo1.pets1;

import typeinfo1.pets.Pet;
import typeinfo1.pets.PetCreator;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    private static String[] typeNames = {
            "typeinfo1.pets.Mutt",
            "typeinfo1.pets.Pug",
            "typeinfo1.pets.EgyptianMau",
            "typeinfo1.pets.Manx",
            "typeinfo1.pets.Cymric",
            "typeinfo1.pets.Rat",
            "typeinfo1.pets.Mouse",
            "typeinfo1.pets.Hamster",
            "typeinfo1.pets1.Gerbil",
    };

    static {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
