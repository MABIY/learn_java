package innerclasses;

/**
 * @author lh
 * Create a class with a non-object constructor and no default constructor.
 * Creaate a second class that has a method that returns a reference to an
 * object of the first class. Create the object that you return by making na
 * anonymous inner class that inherits from the first class.
 **/
class One{
    private String s;

    public One(String s) {
        this.s = s;
    }
    public String showS() {
        return s;
    }
}
public class Ex15 {
    public One makeOne(String s) {
        return new One(s) {

        };
    }

    public static void main(String[] args) {
        Ex15 x = new Ex15();
        System.out.println(x.makeOne("hi").showS());
    }
}
