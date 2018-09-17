package reusing;

import static net.mindview.util.Print.print;

class Homer{
    char doh(char c) {
        print("doh(char)");
        return 'd';
    }

    float doh(float f) {
        print("doh(float)");
        return 1.0f;
    }
}

class Milhouse{}

class Bart extends Homer{
    @Override
    float doh(float f) {
        return super.doh(f);
    }

    void doh(Milhouse m) {
        print("doh(Milhouse)");
    }
}

class Lisa extends Homer{
    void doh(Milhouse m) {
        System.out.println("doh(Milihouse)");
    }
}
public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(.10f);
        b.doh(new Milhouse());
    }
}
