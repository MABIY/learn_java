package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Cat;

/**
 * @author lh
 **/
public class Manx extends Cat {
    public static class Factory implements typeinfo.factory.Factory<Manx> {
        @Override
        public Manx create() {
            return new Manx();
        }
    }
}
