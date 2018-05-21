package initialization;

public class MethodInit3 {
    //int j = g(i);
    int i = f();

    private int f() {
        return 11;
    }

    int g(int n) {
        return n * 10;
    }
}
