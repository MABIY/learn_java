package typeinfo;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-28 16:58
 **/

class Candy{
	static {
		print("Loading Candy");}
}

class Gum{
	static {
		print("Loading Gum");
	}
}

class Cookie{
	static {
		print("loading Cookie");
	}
}
public class SweetShop {
	public static void main(String[] args) {
		print("inside main");
		new Candy();
		print("After creating Candy");
		try {
			Class.forName("typeinfo.Gum");
		} catch (ClassNotFoundException e) {
			print("Couldn't find Gum");
		}
		print("After Class.forName(\"Gum\")");
	}
}
