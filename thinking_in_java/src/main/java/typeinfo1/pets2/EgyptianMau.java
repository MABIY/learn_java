package typeinfo1.pets2;

import typeinfo1.factory.Factory;
import typeinfo1.pets.Cat;

public class EgyptianMau extends Cat {
    public static class Facotry implements Factory<EgyptianMau> {
        @Override
        public EgyptianMau create() {
            return new EgyptianMau();
        }
    }
}
