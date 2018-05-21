package initialization;

public class E11_FinalizeAlwaysCalled {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize() called");
        super.finalize();
    }

    public static void main(String[] args) {
        new E11_FinalizeAlwaysCalled();
        System.gc();
        System.runFinalization();
    }
}
