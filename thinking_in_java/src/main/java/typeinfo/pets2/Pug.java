package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Dog;

/**
 * @author: liuHua
 * @create: 2018-11-30 15:26
 **/

public class Pug extends Dog {
	public static class Factory implements typeinfo.factory.Factory<Pug> {
		@Override
		public Pug create() {
			return new Pug();
		}
	}
}
