package typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-11-30 10:29
 **/

public class ForNameCreator extends PetCreator{
	
	private static List<Class<? extends Pet>> types = new ArrayList<>();
	
	// Types that you want to be randomly created:
	
	private static String[] typeNames = {
			"typeinfo.pets.Mutt",
			"typeinfo.pets.Pug",
			"typeinfo.pets.EgyptianMau",
			"typeinfo.pets.Manx",
			"typeinfo.pets.Cymric",
			"typeinfo.pets.Rat",
			"typeinfo.pets.Mouse",
			"typeinfo.pets.Hamster"
	};
	
	@SuppressWarnings("unchecked")
	private static void loader() {
		for (String name : typeNames) {
			try {
				types.add((Class<? extends Pet>)Class.forName(name));
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	static {
		loader();
	}
	@Override
	public List<Class<? extends Pet>> types() {
		return types;
	}
	
}
