package son;

import test.Father;

/**
 * The type Son.
 *
 * @author lh
 * @date Create in 下午12:32 19-3-21
 */
public class Son extends Father {
    @Override
    protected void test() {
        System.out.println("Son");
    }

    public void test(Object a) {
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.test();
    }
}
