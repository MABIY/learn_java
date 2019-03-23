package test;

import son.Son;

/**
 * @author lh
 * @date Create in 上午9:01 19-3-22
 */
public class Father {
    protected void test() {
        System.out.println("Father");
    }

    public static void main(String[] args) {
        Father father = new Son();
        father.test();
    }
}
