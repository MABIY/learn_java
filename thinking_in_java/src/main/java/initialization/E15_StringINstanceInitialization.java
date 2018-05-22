package initialization;

public class E15_StringINstanceInitialization {
    String s;
    {
        s = "'instance initialization'";
    }

    public E15_StringINstanceInitialization() {
        System.out.println("Default constructor; s= " +s);
    }

    public E15_StringINstanceInitialization(int s) {
        System.out.println("int constructor; s= " + s);
    }

    public static void main(String[] args) {
        new E15_StringINstanceInitialization();
        new E15_StringINstanceInitialization(1);
    }
}
