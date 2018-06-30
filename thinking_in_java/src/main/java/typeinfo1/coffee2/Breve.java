package typeinfo1.coffee2;

import typeinfo1.factory.Factory;

public class Breve extends Coffee {
    public static class Factory implements typeinfo1.factory.Factory<Breve> {
        @Override
        public Breve create() {
            return new Breve();
        }
    }
}
