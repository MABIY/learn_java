package typeinfo;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-29 10:34
 * In ToyTest.java comment out Toy's default constructor and explain what happens
 **/
// Copy-pasted because these interfaces are not public
interface HasBatteries{}

interface Waterproof{}

interface Shoots{}

class Toy{
	// Toy(){}
	Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
	public FancyToy() {
		super(1);
	}
}
public class E01_ToyTest {
	static void printInfo(Class<?> cc) {
		print("Class name: "+ cc.getName() +
				" is interface ? [" + cc.isInterface() + "]");
		print("Simple name: " + cc.getSimpleName());
		print("Canonical name : " + cc.getCanonicalName());
	}
	
	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("typeinfo.FancyToy");
		} catch (ClassNotFoundException e) {
			print("Can't find FancyToy");
			return;
		}
		
		printInfo(c);
		for (Class<?> face : c.getInterfaces()) {
			printInfo(face);
		}
		
		Class<?> up = c.getSuperclass();
		Object obj = null;
		try {
			// Requires default constructor:
			obj = up.newInstance();
		} catch (IllegalAccessException e) {
			print("Cannot access");
			return;
		} catch (InstantiationException e) {
			print("Cannot instantiate");
			return;
		}
		
		printInfo(obj.getClass());
	}
}


