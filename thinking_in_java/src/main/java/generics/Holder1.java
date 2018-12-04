package generics;

/**
 * @author: liuHua
 * @create: 2018-12-04 13:29
 **/
class Automobile{}

public class Holder1 {
	private Automobile a;
	
	public Holder1(Automobile a) {
		this.a = a;
	}
	Automobile get() {
		return a;
	}
}
