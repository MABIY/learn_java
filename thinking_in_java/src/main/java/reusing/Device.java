package reusing;

import reusing.ex15.BasicDevice;

/**
 * @author lh
 * Create a class inside a package. Your class should  contian a protected
 * method. Outside of the package, try to call the protected method and eplain
 * the results. Now inherit from your class and call the protected method from
 * inside a method of your derived class.
 **/
class DeviceFail{
    public static void main(String[] args) {
        BasicDevice fail = new BasicDevice();
        fail.showS();
        // fail.changeS("good-bye"); //cannot access protected method
    }
}

public class Device extends BasicDevice {
    void changeBasic(String t) {
        super.changeS(t);//calls protected method
    }

    public static void main(String[] args) {
        Device d = new Device();
        d.showS();
        d.changeBasic("Changed"); // derived class can access protected
        d.showS();
        DeviceFail.main(args);
    }
}
