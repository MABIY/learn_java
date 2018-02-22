package write.code;

import base.concept.A;

import java.util.ArrayList;
import java.util.List;

public class Test extends A {
    public static void main(String[] args) {
        a(new Object());

        int[] a = new int[7];
        a[1] = (byte) 1;
        Object[] objects = new Object[7];
        objects[1] = new String();
        List<Object> list = new ArrayList<>();
        list.add(new String());

    }

    @Override
    public String aPrint() {
        super.aPrint();
        return null;
    }
    public static  void a(Object argument) {
        System.out.println("Test");
    }
}
