package access;

/**
 * @author lh
 **/
public class FourWays {
    int a = 0;
    public int b = 1;
    protected int c = 2;
    private int d = 3;

    public FourWays() {
        System.out.println("FourWays() constructor");
    }

    void showa() {
        System.out.println(a);
    }

    public void showb() {
        System.out.println(b);
    }

    public void showc() {
        System.out.println(c);
    }

    private void showd() {
        System.out.println(d);
    }
}
