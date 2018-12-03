package typeinfo;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-03 08:36
 * Make ShowMethods a non-public class and verify that
 * the synthesized default constructor no longer appear in
 * the output
 **/

class E18_ShowMethods3 {
	public static String usage = "usage:" + System.lineSeparator()
			+ "E18_ShowMethods3 qualified.class.name" + System.lineSeparator()
			+ "To show all methods in class or: " + System.lineSeparator()
			+ "E18_ShowMethods3 qualified.class.name word" + System.lineSeparator()
			+ "To search for methods involving 'word'";
	public static Pattern p = Pattern.compile("\\w+\\.");
	
	public static void main(String[] args) {
		args = new String[]{"typeinfo.E18_ShowMethods3"};
		if (args.length < 1) {
			print(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor<?>[] ctors = c.getConstructors();
			if (args.length == 1) {
				for (Method method : methods) {
					print(
							p.matcher(method.toString()).replaceAll("")
					);
				}
				
				for (Constructor<?> ctor : ctors) {
					print(
							p.matcher(ctor.toString()).replaceAll("")
					);
				}
				lines = methods.length + ctors.length;
			} else {
				for (Method method : methods) {
					if (method.toString().contains(args[1])) {
						print(
								p.matcher(method.toString()).replaceAll("")
						);
						lines++;
					}
				}
				
				for (Constructor<?> ctor : ctors) {
					if (ctor.toString().indexOf(args[1]) != -1) {
						print(
								p.matcher(
										ctor.toString()
								).replaceAll("")
						);
						
					}
				}
			}
		} catch (ClassNotFoundException e) {
			print("No Such class: " + e);
		}
	}
}
