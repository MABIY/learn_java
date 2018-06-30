package typeinfo1.coffee2;

import typeinfo1.factory.Factory;

public class Cappucino extends Coffee {
    public static class Factory implements typeinfo1.factory.Factory<Cappucino> {
        @Override
        public Cappucino create() {
            return new Cappucino();
        }
    }
}
