package typeinfo;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-30 15:54
 * Using reflection to  show all the methods of a class,
 * even if the methods are defined in the base class.
 **/
	
public class ShowMethods {
	private static String usage = "usage:" + File.separator +
			"ShowMethod qualified.class.name" + File.separator +
			"To show all methods in class or: " + File.separator +
			"ShowMethod qulified.class nmae word" + File.separator +
			"To search for methods involving  'word'";
	private static Pattern p = Pattern.compile("(\\w+?)\\.");
	
	public static void main(String[] args) {
		args = new String[]{ShowMethods.class.getName()};
		if (args.length < 1) {
			print(usage);
			System.exit(0);
		}
		
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if (args.length == 1) {
				for (Method method : methods) {
					Matcher m = p.matcher(method.toString());
					if (m.find()) {
						System.out.println(m.group());
					}
				}
				for (Constructor ctor : ctors) {
					print(p.matcher(ctor.toString()).replaceAll(""));
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
				
				for (Constructor ctor : ctors) {
					if (ctor.toString().contains(args[1])) {
						lines++;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
			
}
