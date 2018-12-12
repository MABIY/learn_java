package generics;

/**
 * @author: liuHua
 * @create: 2018-12-12 16:09
 **/

public class CaptureConversion {
	static <T> void f1(Holder<T> holder) {
		T t = holder.get();
		System.out.println(t.getClass().getSimpleName());
	}
	
	static void f2(Holder<?> holder) {
		f1(holder); // Call with captured type
	}
	
	public static void main(String[] args) {
		Holder raw = new Holder<Integer>(1);
		f1(raw); //Produces warnings
		f2(raw); // No Warnings
		Holder rawBasic = new Holder();
		rawBasic.set(new Object());//Warning
		f2(rawBasic); // No warnings
		// Upcast to Holder<?> , still figures it out:
		Holder<?> wildcarded = new Holder<Double>(1.1);
		f2(wildcarded);
	}
}
