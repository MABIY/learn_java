package typeinfo;

/**
 * @author: liuHua
 * @create: 2018-11-30 09:55
 **/

class Building {}
class House extends Building{}
public class ClassCasts {
	public static void main(String[] args) {
		Building b = new House();
		Class<?> houseType = House.class;
		Object h = houseType.cast(b);
		h = (House) b; // ... or just do this
	}
}
