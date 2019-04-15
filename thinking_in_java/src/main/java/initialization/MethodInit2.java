package initialization;

/**
 * @author lh
 **/
public class MethodInit2 {
    int i = f();

    int j = g(i);

    private int g(int i) {
        return i * 10;
    }

    private int f() {
        return 11;
    }
}
