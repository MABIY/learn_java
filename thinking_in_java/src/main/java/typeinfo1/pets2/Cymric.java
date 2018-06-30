package typeinfo1.pets2;

import typeinfo1.factory.Factory;
import typeinfo1.pets.Manx;

public class Cymric extends Manx {
    public static class Factory implements typeinfo1.factory.Factory<Cymric> {
        @Override
        public Cymric create() {
            return new Cymric();
        }
    }
}
