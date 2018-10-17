package exceptions;

public class E30_Human{
    static void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new Annoyance();
                case 1:
                    throw new Sneeze();
                default:
                    return;
            }
        } catch (Exception e) { // Adapt to unchecked
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Let RuntimeException go out of the method:
        throwRuntimeException(2);
        // Or let catch exceptions

        for (int i = 0; i < 2; i++) {
            try {
                throwRuntimeException(i);
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (Sneeze e) {
                    System.out.println("Caught Sneeze");
                } catch (Annoyance e) {
                    System.out.println("Caught Annoyance");
                } catch (Throwable t) {
                    System.out.println(t);
                }
            }
        }
    }

}
