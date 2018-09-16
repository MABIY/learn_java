package reusing;

import static access.util.Print.print;

class Art{
    public int a;
    {
        System.out.println("Art" + a);
    }
    Art() {
        print("Art constructor");
    }
}

class Drawing extends Art{
    public int b;
    {
        System.out.println("Drawing b");
    }
    public Drawing() {
        print("Drawing constructor");
    }
}
public class Cartoon extends Drawing{

    public int c;
    {
        System.out.println("Drawing c");
    }
    public int a;
    {
        System.out.println(a);
    }
    public Cartoon() {
        print("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}
