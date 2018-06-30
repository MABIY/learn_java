package typeinfo1.pets2;

import typeinfo1.factory.Factory;
import typeinfo1.pets.Dog;

public class Mutt extends Dog {
    public static class Factory implements typeinfo1.factory.Factory<Mutt> {
        @Override
        public Mutt create() {
            return new Mutt();
        }
    }
}
