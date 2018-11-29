package typeinfo;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-29 14:48
 * Modify the previous exercise so that is uses
 * Class.getDeclaredFields() to also display
 * information about the fields in the class
 **/

interface Iface{
	int i = 47;
	
	void f();
}

class Base implements Iface {
	String s;
	String d;
	@Override
	public void f() {
		System.out.println("Base.f");
	}
}
class Composed{
	Base b;
}

class Derived extends Base{
	Composed c;
	String s;
}
public class E09_GetDeclaredFields {
	static Set<Class<?>> alreadyDisplay =
			new HashSet<>();
	
	static void printClasses(Class<?> c) {
		// getSuperClass() returns null on Object:
		if (c == null) {
			return;
		}
		print(c.getName());
		Field[] fields = c.getDeclaredFields();
		if (fields.length != 0) {
			print("Fields:");
		}
		for (Field fld : fields) {
			print("   " + fld);
		}
		for (Field field : fields) {
			Class<?> k = field.getType();
			if (!alreadyDisplay.contains(k)) {
				printClasses(k);
				alreadyDisplay.add(k);
			}
		}
		
		// Produces the interfaces that this class
		// implements
		
		for (Class<?> k : c.getInterfaces()) {
			print("Interface: " + k.getName());
			printClasses(k.getSuperclass());
		}
		printClasses(c.getSuperclass());
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		args = new String[]{"typeinfo.Derived"};
		for (int i = 0; i < args.length; i++) {
			print("displaying " + args[i]);
			printClasses(Class.forName(args[i]));
			if (i < args.length - 1) {
				System.out.println("==========");
			}
		}
	}
}
