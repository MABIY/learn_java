package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Rodent;

/**
 * @author lh
 **/
public class Hamster extends Rodent {
    public static class Factory implements typeinfo.factory.Factory<Hamster> {
        @Override
        public Hamster create() {
            return new Hamster();
        }
    }
}
