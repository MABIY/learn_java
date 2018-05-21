package initialization;

public class MethodInit2 {
    int i = f();
    int j = g(i);

    int g(int i) {
        return i * 10;
    }

    int f() {
        return 11;
    }

}
