package initialization;

/**
 * @author lh
 * create a class with finalize() method that prints a message. In main(),
 * create an object of your class. Explain the behavior of your program
 **/
class WebBank {
    boolean loggedIn = false;

    public WebBank(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    void logIn() {
        loggedIn = true;
    }

    void logOut() {
        loggedIn = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (loggedIn) {
            System.out.println("Error: still logged in");
        }
        // super.finalize();
    }
}
public class TerminationConditionEx {
    public static void main(String[] args) {
        WebBank bank1 = new WebBank(true);
        WebBank bank2 = new WebBank(true);
        //Proper cleanup: log out bank1 before going home
        bank1.logOut();
        // Drop the reference, forget to cleanup:
        new WebBank(true);
        // Force garbage collection and finalization:
        System.gc();
    }
}
