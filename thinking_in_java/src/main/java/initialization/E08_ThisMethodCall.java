package initialization;

public class E08_ThisMethodCall {
    public void a() {
        b();
        this.b();
    }

    public void b() {
        System.out.println("b() called");
    }

    public static void main(String[] args) {
        new E08_ThisMethodCall().a();
    }
}
