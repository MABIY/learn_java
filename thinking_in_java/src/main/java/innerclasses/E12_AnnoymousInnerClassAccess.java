package innerclasses;

public class E12_AnnoymousInnerClassAccess {
    private int i = 10;
    private void f() {
        System.out.println("E12_AnnoymousInnerClassAccess.f");
    }

    public void h() {
        new Object() {
            void g() {
                i++;
                f();
            }
        }.g();
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        E12_AnnoymousInnerClassAccess ica = new E12_AnnoymousInnerClassAccess();
        ica.h();
    }
}
