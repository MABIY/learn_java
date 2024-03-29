package arrays;

import com.sun.jndi.ldap.Ber;

/**
 * @author lh
 * Create a method that takes an array of
 * BerylliumSpherre as an argument. Call the method,
 * creating the arguemnt dynamically, Demonstrate
 * that ordinary aggregate array initialization
 * doesn't work in this case, Discover the only
 * situations where ordinary aggregate array
 * initialization works, and where dynamic aggregate
 * initialization is redundant.
 **/
public class E01_ArrayInitialization {
    static void hide(BerylliumSphere[] s) {
        System.out.println("Hiding " + s.length + " sphere(s)");
    }

    public static void main(String[] args) {
        // Dynamic aggregate initialization:
        hide(new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()});
        // The following line produces a compilation error.
        // hide({new BerylliumSphere()});
        // Aggregate initialization:
        BerylliumSphere[] d = {
                new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()
        };
        hide(d);
        // Dynamic aggergate initialization is redundant
        // in the next case:
        BerylliumSphere[] a = new BerylliumSphere[]{
                new BerylliumSphere(), new BerylliumSphere(),
                new BerylliumSphere()
        };
        hide(a);
    }

}
