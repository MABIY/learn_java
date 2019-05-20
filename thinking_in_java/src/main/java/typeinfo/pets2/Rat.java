package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Rodent;

/**
 * @author lh
 **/
public class Rat extends Rodent {
    public static class Factory implements typeinfo.factory.Factory<Rat> {
        @Override
        public Rat create() {
            return new Rat();
        }
    }
}
