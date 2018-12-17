package generics;

/**
 * @author: liuHua
 * @create: 2018-12-17 11:57
 **/

class Subtype extends BasicHolder<Subtype> {
}
public class CRGWithBasicHolder {
	public static void main(String[] args) {
		Subtype st1 = new Subtype(), st2 = new Subtype();
		st1.set(st2);
		Subtype st3 = st1.get();
		st1.f();
	}
}
