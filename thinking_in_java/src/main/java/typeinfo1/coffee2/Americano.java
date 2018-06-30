package typeinfo1.coffee2;

import typeinfo1.factory.Factory;

public class Americano extends Coffee{
    public static class Factory implements typeinfo1.factory.Factory<Americano> {
        @Override
        public Americano create() {
            return new Americano();
        }
    }
}
