package typeinfo;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-29 14:23
 * Modify SweetShop.java so that each type of
 * object creation is controlled by a
 * command-line argument, That is , if your
 * command line is "java SweetShop Candy," then
 * only the Candy object is created. Notice how
 * you can control which Class objects are loaded
 * via the command-line argument
 **/

class Candy7{
	static {
		print("Loading Candy");
	}
}

class Gum7{
	static {
		print("Loading Gum");
	}
}

class Cookie7 {
	static {
		print("Loading Cookie");
	}
}
public class E07_CommandLoad {
	public static void main(String[] args) throws ClassNotFoundException {
		args = new String[]{"typeinfo.Gum","typeinfo.Cookie"};
		for (String arg : args) {
			Class.forName(arg);
		}
	}
}
