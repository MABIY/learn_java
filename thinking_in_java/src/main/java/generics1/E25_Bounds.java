package generics1;

interface Low {
    void c();

    void d();
}

class TopLowImpl implements Top,Low{
    @Override
    public void c() {

    }

    @Override
    public void d() {

    }

    @Override
    public void a() {

    }

    @Override
    public void b() {

    }
}

public class E25_Bounds {
    static <T extends Top> void top(T obj) {
        obj.a();
        obj.b();
    }

    static <T extends Low> void low(T obj) {
        obj.c();
        obj.d();
    }

    public static void main(String[] args) {
        TopLowImpl tli = new TopLowImpl();
        top(tli);
        top(tli);
    }
}
