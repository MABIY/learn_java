package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Rodent;

/**
 * @author: liuHua
 * @create: 2018-11-30 15:24
 **/

public class Hamster extends Rodent {
	public static class Factory implements typeinfo.factory.Factory<Hamster> {
		@Override
		public Hamster create() {
			return new Hamster();
		}
	}
}
