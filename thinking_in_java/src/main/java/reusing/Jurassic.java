package reusing;

/**
 * @author lh
 * Making an entire class final
 **/
class SmallBranin{

}
final class Dinosaur{
    int i = 7;
    int j = 1;
    SmallBranin x = new SmallBranin();

    void f() {}
}

// error: Cannot extend final class 'Dinosaur'
// class Further extends Dinosaur{
// }

public class Jurassic {
    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
    }
}
