package reusing;

/**
 * @author lh
 * Create a final class and attempt to inherit from it
 **/
class SmallBrain{}
final class Dinosaur1{
    SmallBranin x = new SmallBranin();
}

// class Futher extends Dinosaur{} // error: cannot inherit from final Dinosaur
public class JurassicEx {
    public static void main(String[] args) {
        Dinosaur1 d = new Dinosaur1();
    }
}
