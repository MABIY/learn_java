package typeinfo1.pets2;

import typeinfo1.factory.Factory;
import typeinfo1.pets.Cat;

public class Manx extends Cat {
    public static class Factory implements typeinfo1.factory.Factory<Manx> {

        @Override
        public Manx create() {
            return new Manx();
        }
    }
}
