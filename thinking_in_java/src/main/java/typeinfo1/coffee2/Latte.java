package typeinfo1.coffee2;

import typeinfo1.factory.Factory;

public class Latte extends Coffee {
    public static class Factory implements typeinfo1.factory.Factory<Latte> {
        @Override
        public Latte create() {
            return new Latte();
        }
    }
}
