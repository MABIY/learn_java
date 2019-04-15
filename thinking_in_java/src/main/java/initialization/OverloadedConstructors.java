package initialization;

/**
 * @author lh
 * Create a class with two (overloaded) constructors. Using 'this',call
 * the second constructor from inside the first one.
 **/

class Doc3{
    public Doc3(int i) {
        this("MD");
        int yearsTraining = i;
        System.out.println("New doc with " + i + "years of training");
    }

    Doc3(String s) {
        String degree = s;
        System.out.println("New doc with " + s + " degree");
    }

    void intubate() {
        System.out.println("prepare patient");
        laryngoscopy();
    }

    void laryngoscopy() {
        System.out.println("use laryngoscope");
    }

}
public class OverloadedConstructors {
    public static void main(String[] args) {
        new Doc3(8).intubate();
    }
}
