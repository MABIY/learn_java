package typeinfo1.pets2;

import typeinfo1.factory.Factory;
import typeinfo1.pets.Dog;

public class Pug extends Dog {
    public static class Factory implements typeinfo1.factory.Factory<Pug> {
        @Override
        public Pug create() {
            return new Pug();
        }
    }
}
