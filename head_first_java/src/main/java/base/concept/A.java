package base.concept;

import write.code.Test;

import java.io.ObjectInputStream;

public class A {
    protected Object aPrint() {
        System.out.println("a print");
         return null;
    }

    public static  void a(Object argument) {
        System.out.println("A");
    }

    public static void main(String[] args) {
        A a = new Test();
        a.aPrint();
        int[] b = new int[7];
    }

}

