package typeinfo1.pets2;

import typeinfo1.factory.Factory;
import typeinfo1.pets.Rodent;

public class Mouse extends Rodent {
    public static class Factory implements typeinfo1.factory.Factory<Mouse> {
        @Override
        public Mouse create() {
            return new Mouse();
        }
    }
}
