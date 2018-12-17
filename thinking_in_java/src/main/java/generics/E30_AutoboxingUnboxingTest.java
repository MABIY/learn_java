package generics;

import static net.mindview.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-12 16:54
 * Create a Holder for each of the primitive
 * wrapper types,and show that autoboxing and autounboxing works
 * for hte set() and get()
 * methods of each instance.
 **/
public class E30_AutoboxingUnboxingTest {
	public static void main(String[] args) {
		Holder<Integer> hi = new Holder<>();
		hi.set(1);
		int i = hi.get();
		print(i ==1);
		Holder<Byte> hb = new Holder<>();
		hb.set((byte)1);
		byte b = hb.get();
		print(b ==1);
		Holder<Short> hs = new Holder<>();
		hs.set((short)1);
		short s = hs.get();
		print(s == 1);
		Holder<Long> hl = new Holder<>();
		hl.set(1L);
		long l = hl.get();
		print(l == 1);
		Holder<Float> hf = new Holder<>();
		hf.set(1.0F);
		float f = hf.get();
		print(f == 1.0f);
		Holder<Double> hd = new Holder<>();
		hd.set(1.0);
		double d = hd.get();
		print(d == 1.0);
		Holder<Character> hc = new Holder<>();
		hc.set('A');
		char c = hc.get();
		print(c == 'A');
		Holder<Boolean> hbool = new Holder<>();
		hbool.set(true);
		boolean bool = hbool.get();
		print(bool);
	}
}