package typeinfo;

import java.util.Random;

/**
 * @author: liuHua
 * @create: 2018-11-30 09:12
 **/

class Initable{
	static final int staticFinal = 47;
	static final int staticFinal2 =
			ClassInitializaiton.rand.nextInt(1000);
	static {
		System.out.println("Initializting Initable");
	}
}

class Initable2{
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable3{
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}
public class ClassInitializaiton {
	public static Random rand = new Random(47);
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		// Does not trigger initialization:
		System.out.println(Initable.staticFinal);
		// Does trigger initialization:
		System.out.println(Initable.staticFinal2);
		//Does trigger initialization:
		System.out.println(Initable2.staticNonFinal);
		Class initable2 = Class.forName("typeinfo.Initable3");
		System.out.println("After creating Initable2 ref");
		System.out.println(Initable3.staticNonFinal);
	}
}
