package typeinfo1.pets2;

import typeinfo1.factory.Factory;
import typeinfo1.pets.Rodent;

public class Rat extends Rodent {
    public static class Factory implements typeinfo1.factory.Factory<Rat> {

        @Override
        public Rat create() {
            return new Rat();
        }
    }
}
