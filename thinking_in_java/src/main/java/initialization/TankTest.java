package initialization;

/**
 * @author lh
 * Create a class called Tank tha can filled and emptied, and has a termination condition that it must be empty when the object is cleanup up
 **/
class Tank{
    int howFull = 0;

    public Tank() {
        this(0);
    }

    public Tank(int howFull) {
        this.howFull = howFull;
    }

    void sayHowFull() {
        if (howFull == 0) {
            System.out.println("Tank is empty");
        } else {
            System.out.println("Tank filling status = " + howFull);
        }
    }

    void empty() {
        howFull = 0;
    }

    @Override
    protected void finalize() {
        if (howFull != 0) {
            System.out.println("Error: Tank not empty" + howFull);
        }

        // Normally, you'll alse od this:
        // super.finalize();// Call the base-class version
    }
}
public class TankTest {
    public static void main(String[] args) {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank(3);
        Tank tank3 = new Tank(5);
        // Proper cleanup: empty tank before going home
        tank2.empty();
        // Drop the reference,forget to cleanup
        new Tank(6);
        System.out.println("Check tanks:");
        System.out.println("tank1: ");
        tank1.sayHowFull();
        System.out.println("tank2: ");
        tank2.sayHowFull();
        System.out.println("tank3: ");
        tank3.sayHowFull();
        System.out.println("first forced gc()");
        System.gc();
        // Force finalization on exit but using method deprecated since JDK 1.1
        System.out.println("try deprecated runFinalizaersOnExit(true)");
        System.runFinalizersOnExit(true);
        System.out.println("last forced gc()");
        System.gc();
    }
}
