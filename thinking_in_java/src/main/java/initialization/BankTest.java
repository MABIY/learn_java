package initialization;

/**
 * @author lh
 * Modify hte previous exercise to that finalize() will always be called.
 **/
public class BankTest {
    public static void main(String[] args) {
        WebBank bank1 = new WebBank(true);
        WebBank bank2 = new WebBank(false);
        new WebBank(true);
        // Proper cleanup: log out of bank1 before going home:
        bank1.logOut();
        //Forget to logout of bank2 and unnamed new bank
        // Attempts to finalize any missed banks
        System.out.println("Try 1: ");
        System.runFinalization();
        System.out.println("Try 2: ");
        Runtime.getRuntime().runFinalization();
        System.out.println("Try 3: ");
        System.gc();
        System.out.println("Try 4: ");
        // using deprecated since 1.1 methdod
        System.runFinalizersOnExit(true);
    }
}
