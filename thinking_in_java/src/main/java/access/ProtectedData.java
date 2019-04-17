package access;

/**
 * @author lh
 * Create a class  with protected data, Create a second class in the same file with
 * a method that manipulates the protected data in the first class
 **/
class SomeData{
    protected int a = 123;
}

class DataChanger{
    static void change(SomeData sd, int i) {
        sd.a = i;
    }
}
public class ProtectedData {
    public static void main(String[] args) {
        SomeData x = new SomeData();
        System.out.println(x.a);
        DataChanger.change(x, 99);
        System.out.println(x.a);
    }
}
