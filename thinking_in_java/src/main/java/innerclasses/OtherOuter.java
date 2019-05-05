package innerclasses;

/**
 * @author lh
 * Create a class with an inner class. In a separater class, make an instance of the inner class.
 **/
class Outer{
    class Inner{
        public Inner() {
            System.out.println("Outer.Inner()");
        }
    }
}
public class OtherOuter {
    public static void main(String[] args) {
        // must first create outer class object:
        Outer o = new Outer();
        // then create inner class object:
        Outer.Inner oi = o.new Inner();
    }
}
