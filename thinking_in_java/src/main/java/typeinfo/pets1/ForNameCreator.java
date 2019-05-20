package typeinfo.pets1;

import typeinfo.pets.Pet;
import typeinfo.pets.PetCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 **/
public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    // Types that you want to randomly created:
    private static String[] typeNames = {
            "typeinfo.pets.Mutt",
            "typeinfo.pets.Pug",
            "typeinfo.pets.EgyptianMau",
            "typeinfo.pets.Manx",
            "typeinfo.pets.Cymric",
            "typeinfo.pets.Rat",
            "typeinfo.pets.Mouse",
            "typeinfo.pets.Hamster",
            "typeinfo.pets1.Gerbil"
    };
    static {
        try {
            for (String name : typeNames) {
                types.add(
                        (Class<? extends Pet>) Class.forName(name)
                );
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
