package typeinfo.pets2;

import typeinfo.factory.Factory;
import typeinfo.pets.Cat;

/**
 * @author: liuHua
 * @create: 2018-11-30 15:24
 **/

public class EgyptianMau extends Cat {
	public static class Factory implements typeinfo.factory.Factory<EgyptianMau> {
		@Override
		public EgyptianMau create() {
			return new EgyptianMau();
		}
	}
}
