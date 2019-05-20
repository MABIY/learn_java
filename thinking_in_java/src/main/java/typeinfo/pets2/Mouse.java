package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Rodent;

/**
 * @author lh
 **/
public class Mouse extends Rodent {
    public static class Factory implements typeinfo.factory.Factory<Mouse> {
        @Override
        public Mouse create() {
            return new Mouse();
        }
    }

}
