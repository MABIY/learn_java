package interfaces;

/**
 * @author lh
 * Modify the previous exercise by creating an abstract class and
 * inheriting that into the derived class.
 **/
interface History15 {
    void u();
    void v();
}

interface Exam15{
   void w();
   void x();
}
interface Labs15{
   void y();
   void z();
}
interface Workup15 extends History15,Exam15,Labs15{
    void zz();
}
abstract class Docker15{
   private int i= 0;
   abstract void doc();
}

class Anesthesiologist15 extends Docker15 implements Workup15{
    @Override
    void doc() { // must override abstract method in Doctor

    }

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

    private int j = 0;
}
public class Ex15 {
    public static void m1(History15 history){
        history.v();
    }

    public static void m2(Exam15 exam) {
        exam.w();
    }
    public static void m3(Labs15 labs){
        labs.y();
    }
    public static void m4(Workup15 workup){
        workup.zz();
    }

    public static void main(String[] args) {
        Anesthesiologist15 anes = new Anesthesiologist15();
        m1(anes);
        m2(anes);
        m3(anes);
        m4(anes);
    }
}
