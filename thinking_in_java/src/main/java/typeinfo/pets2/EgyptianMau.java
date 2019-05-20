package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Cat;

/**
 * @author lh
 **/
public class EgyptianMau extends Cat {
    public static class Factory implements typeinfo.factory.Factory<EgyptianMau> {
        @Override
        public EgyptianMau create() {
            return new EgyptianMau();
        }
    }
}
