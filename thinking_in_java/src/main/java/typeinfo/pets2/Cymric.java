package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Manx;

/**
 * Implement a new PetCreator Using Registered
 * Factories, and modify the Pets Facade so that
 * it uses this one instead of the other two.
 * Ensure that the rest of the examples that use
 * Pets.java still work correctly.
 **/
public class Cymric extends Manx {
    public static class Factory implements typeinfo.factory.Factory<Cymric> {
        @Override
        public Cymric create() {
            return new Cymric();
        }
    }

}
