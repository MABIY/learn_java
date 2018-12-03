package typeinfo;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-03 09:42
 * Look up the interface for java.lang.Class in
 * the JDK documentation from java.sun.com.Write a
 * program that takes the name of a class
 * as a command-line argument, then uses the
 * Class methods to dump all the information
 * available for the class .Test you program
 * with a standard library class and a class you
 * create
 **/

public class E20_ClassDump {
	public static void display(String msg, Object[] vals) {
		print(msg);
		for (Object val : vals) {
			print("  " + val);
		}
	}
	
	public static void classInfo(Class<?> c) {
		print("c.getName(): " + c.getName());
		print("c.getPackage(): " + c.getPackage());
		print("c.getSuperClass(): " + c.getSuperclass());
		// This produces all the classes declared as members:
		display("c.getDeclaredClasses()",c.getDeclaredClasses());
		// include static class of object and interface
		display("c.getClasses()", c.getClasses());
		
		display("c.getInterfaces()", c.getInterfaces());
		// The 'Declared' version includes all
		// version ,n ot just public
		display("c.getDeclaredMethods()", c.getDeclaredMethods());
		display("c.getMethods()", c.getMethods());
		display("c.getDeclaredConstructors()",c.getDeclaredConstructors());
		display("c.getConstructors()",c.getConstructors());
		display("c.getDeclaredFileds()",c.getDeclaredFields());
		display("c.getFields()", c.getFields());
		if (c.getSuperclass() != null) {
			print("Base class: -----");
			classInfo(c.getSuperclass());
		}
		print("End of " + c.getName());
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		args = new String[]{"typeinfo.E20_ClassDump"};
		for (String arg : args) {
			classInfo(Class.forName(arg));
		}
	}
}
