package typeinfo;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-30 15:38
 **/
class Base1{}
class Derived1 extends Base1{}
public class FamilyVSExactType {
	static void test(Object x) {
		print("Testing x of type " + x.getClass());
		print("x instanceof Base " + (x instanceof  Base));
		print("x instanceof Derived " + (x instanceof Derived));
		print("Base.isInstance(x) " + Base.class.isInstance(x));
		print("Derived.isInstance(x) " +
				Derived.class.isInstance(x));
		print("x.getClass() == Base.class " +
				(x.getClass() == Base.class));
		print("x.getClass() == Derived.class " + (x.getClass() == Derived.class));
		print("x.getClass().equals(Base.class)" + x.getClass().equals(Base.class));
		print("x.getClass().equals(Derived.class)" + x.getClass().equals(Derived.class));
	}
	
	public static void main(String[] args) {
		test(new Base());
		test(new Derived());
	}
}
