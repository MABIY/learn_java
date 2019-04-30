package interfaces;

import interfaces.ex5.Ex5;

/**
 * @author lh
 * Create an interface containing three methods, in its own package. Implement it
 * in another package.
 * solution include, in package interfaces.ex5
 **/
public class TestEx5 implements Ex5 {
    @Override
    public void sayOne() {
        System.out.println("one");
    }

    @Override
    public void sayTwo() {
        System.out.println("two");
    }

    @Override
    public void sayThree() {
        System.out.println("three");
    }

    public static void main(String[] args) {
        TestEx5 x = new TestEx5();
        x.sayOne();
        x.sayTwo();
        x.sayThree();
    }
}
