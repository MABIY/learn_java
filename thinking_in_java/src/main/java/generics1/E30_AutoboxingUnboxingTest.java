package generics1;

public class E30_AutoboxingUnboxingTest {
    public static void main(String[] args) {
        Holder<Integer> hi = new Holder<>();
        hi.set(1);
        int i = hi.get();
        System.out.println(i == 1);
        Holder<Byte> hb = new Holder<Byte>();
        hb.set((byte) 1);
        byte b = hb.get();
        System.out.println(b == 1);
        Holder<Short> hs = new Holder<>();
        hs.set((short)1);
        short s = hs.get();
        System.out.println(s == 1);
        Holder<Long> hl = new Holder<>();
        hl.set(1L);
        long l = hl.get();
        System.out.println(l == 1);
        Holder<Float> hf = new Holder<>();
        hf.set(1.0f);
        float f = hf.get();
        System.out.println(f = 1.0f);
        Holder<Double> hd = new Holder<>();
        hd.set(1.0);
        double d = hd.get();
        System.out.println(d == 1.0);
        Holder<Character> hc = new Holder<>();
        hc.set('A');
        char c = hc.get();
        System.out.println(c == 'A');
        Holder<Boolean> hbool = new Holder<>();
        hbool.set(true);
        boolean bool = hbool.get();
        System.out.println(bool);
    }
}
