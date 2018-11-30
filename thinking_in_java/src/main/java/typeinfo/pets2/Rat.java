package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Rodent;

/**
 * @author: liuHua
 * @create: 2018-11-30 15:27
 **/

public class Rat extends Rodent {
	public static class Factory implements typeinfo.factory.Factory<Rat> {
		@Override
		public Rat create() {
			return new Rat();
		}
	}
}
