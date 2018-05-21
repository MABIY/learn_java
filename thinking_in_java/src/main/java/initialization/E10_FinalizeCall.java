package initialization;

public class E10_FinalizeCall {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize called");
        super.finalize();
    }

    public static void main(String[] args) {
        new E10_FinalizeCall();
    }
}
