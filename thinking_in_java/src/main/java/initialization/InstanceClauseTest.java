package initialization;

/**
 * @author lh
 **/
class Tester1{
    String s;
    {
        s = "initializing string in Tester";
        System.out.println(s);
    }

    public Tester1() {
        System.out.println("Tester()");
    }
}

public class InstanceClauseTest {
    public static void main(String[] args) {
        new Tester1();
    }
}
