package typeinfo1.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    // Types that you want to be randomly created
    private static String[] typeNames = {
            "typeinfo1.pets.Mutt",
            "typeinfo1.pets.Pug",
            "typeinfo1.pets.EgyptianMau",
            "typeinfo1.pets.Manx",
            "typeinfo1.pets.Cymric",
            "typeinfo1.pets.Rat",
            "typeinfo1.pets.Mouse",
            "typeinfo1.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
