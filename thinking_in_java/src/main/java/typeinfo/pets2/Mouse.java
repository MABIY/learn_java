package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Rodent;

/**
 * @author: liuHua
 * @create: 2018-11-30 15:25
 **/

public class Mouse extends Rodent {
	public static class Factory implements typeinfo.factory.Factory<Mouse> {
		@Override
		public Mouse create() {
			return new Mouse();
		}
	}
}
