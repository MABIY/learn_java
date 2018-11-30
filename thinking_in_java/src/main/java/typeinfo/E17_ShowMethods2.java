package typeinfo;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static access.util.Print.print;

/**
 * @author: l
 * iuHua
 * @create: 2018-11-30 17:05
 * Modify the regular expression in ShowMethods.java to
 * also strip off keywords native and final.
 **/

public class E17_ShowMethods2 {
	private static String usage = "usage:" + File.separator+
			"E17_ShowMethods2 qualified.class.name "+File.separator+
			"to show all methods in class or :"+ File.separator +
			"E17_ShowMethods2 qualified.class.name word" + File.separator +
			"To search for methods involving 'word'";
	private static Pattern p = Pattern.compile("\\w+\\.|native\\s|final\\s");
	
	public static void main(String[] args) {
		args = new String[]{E17_ShowMethods2.class.getName()};
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
					print(p.matcher(ctor.toString()).replaceAll(""));
				}
				lines = methods.length + ctors.length;
			}else{
				for (Method method: methods) {
					if (method.toString().indexOf(args[1]) != 1) {
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
										ctor.toString()).replaceAll("")
						);
						lines++;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
