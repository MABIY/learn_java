package typeinfo1.coffee2;

import typeinfo1.factory.Factory;

public class Mocha extends Coffee{
    public static class Factory implements typeinfo1.factory.Factory<Mocha> {
        @Override
        public Mocha create() {
            return new Mocha();
        }
    }
}
