package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Cat;

/**
 * @author: liuHua
 * @create: 2018-11-30 15:25
 **/

public class Manx extends Cat {
	public static class Factory implements typeinfo.factory.Factory<Manx> {
		@Override
		public Manx create() {
			return new Manx();
		}
	}
}
