package enumerated;

import static net.lh.util.Print.print;

/**
 * @author lh
 **/
public enum  OverrideConstantSpecific {
    NUT,BOLT,
    WASHER{
        @Override
        void f() {
            print("Overridden method");
        }
    };

    void f() {
        print("default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs: values()) {
            print(ocs+": ");
            ocs.f();
        }
    }

}
