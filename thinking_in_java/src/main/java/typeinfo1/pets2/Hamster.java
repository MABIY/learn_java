package typeinfo1.pets2;

import typeinfo1.factory.Factory;
import typeinfo1.pets.Rodent;

public class Hamster extends Rodent {
    public static class Factory implements typeinfo1.factory.Factory<Hamster> {
        @Override
        public Hamster create() {
            return new Hamster();
        }
    }
}
