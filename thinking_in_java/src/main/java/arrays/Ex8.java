package arrays;

class A{}
public class Ex8<T> {
    T[] a = (T[]) new Object[2];

    public static void main(String[] args) {
        Ex8<String> stringEx8 = new Ex8<String>();
        String[] sa = new String[2];
        //sa[0] = new Integer(0); // error: incompatible types
        Object[] oa = new Object[3];
        oa[0] = new String("hi");
        oa[1] = new A(); // arbitray object ok
        int x = 2;
        oa[2] = 2; // Autoboxing converts int to Integer;
        System.out.println("oa[2]: " + oa[2].getClass());
        oa = sa;
        System.out.println("oa: " + oa.getClass());
    }
}

