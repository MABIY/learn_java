package reusing.ex15;

/**
 * @author lh
 **/
public class BasicDevice {
    private String s = "Original";

    public BasicDevice() {
        s = "Original";
    }

    protected void changeS(String s) { //outside package, only derived
         this.s = s;                              // classes can access protected method
    }

    public void showS() {
        System.out.println(s);
    }
}
