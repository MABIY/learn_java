package reusing;

class SamllBrain{}
final class Dinosaur{
    int i = 7;
    int j = 1;
    SamllBrain x = new SamllBrain();
    void f(){}
}

//!class Further extends Dinosaur {}
// error: Cannot extend final class 'Dinosaur'
public class Jurassic {
    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
    }
}
