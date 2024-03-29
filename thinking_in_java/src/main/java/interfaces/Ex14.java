package interfaces;

/**
 * @author lh
 * Create three interfaces, each with two methods.Inherit a new interface
 * that combines the three,adding a new method.Create a class by implementing
 * the new interface and also inheriting from a concrete class.
 * Now write four methods, each of wich takes one of the four interfaces as
 * an argument. In main(),create an object of your class and pass it to each
 *  of the methods.
 **/
interface History{
    void u();

    void v();
}

interface Exam{
    void w();

    void x();
}

interface Labs{
    void y();

    void z();
}
interface Workup extends History,Exam,Labs{
    void zz();
}
class Doctor{
    private int i = 0;
    public void doc() {

    }
}

class Anesthesiologist extends Doctor implements Workup{
    private int j = 0;
    @Override
    public void u() {

    }

    @Override
    public void v() {

    }

    @Override
    public void w() {

    }

    @Override
    public void x() {

    }

    @Override
    public void y() {

    }

    @Override
    public void z() {

    }

    @Override
    public void zz() {

    }
}
public class Ex14 {
    public static void m1(History history) {
        history.v();
    }

    public static void m2(Exam exam) {
        exam.w();
    }

    public static void m3(Labs labs) {
        labs.y();
    }

    public static void m4(Workup workup) {
        workup.zz();
    }

    public static void main(String[] args) {
        Anesthesiologist anes = new Anesthesiologist();
        m1(anes);
        m2(anes);
        m3(anes);
        m4(anes);
    }
}
