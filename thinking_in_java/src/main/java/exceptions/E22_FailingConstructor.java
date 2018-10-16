package exceptions;

class FailingConstructor{
    public FailingConstructor(boolean fail) throws ConstructionException{
        if (fail) {
            throw new ConstructionException();
        }
    }
}
public class E22_FailingConstructor {
    public static void main(String[] args) {
        for (boolean b = false; ; b = !b) {
            try {
                System.out.println("Constructiong... ");
                FailingConstructor fc = new FailingConstructor(b);
                try {
                    System.out.println("Processing.... ");
                }finally {
                    System.out.println("Cleanup... ");
                }
            } catch (ConstructionException e) {
                System.out.println("Constructor has failed: " + e);
                break;
            }
        }
    }
}
