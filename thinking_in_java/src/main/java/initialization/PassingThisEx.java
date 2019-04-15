package initialization;

/**
 * @author lh
 * Create a class with two methods within first method,call the
 * second method twice: the first time without using this ,aand the second time
 * using this - just to see it working; you should not use this form in practice
 **/
class Doc {
    void intubate() {
        System.out.println("prepare patient");
        laryngoscopy();
        this.laryngoscopy();
    }

    void laryngoscopy() {
        System.out.println("use laryngoscope");
    }
}

public class PassingThisEx {
    public static void main(String[] args) {
        new Doc().intubate();
    }
}
