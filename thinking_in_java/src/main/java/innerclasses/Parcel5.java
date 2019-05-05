package innerclasses;

/**
 * @author lh
 * Nesing a class within a method:
 **/
public class Parcel5 {
    public Destination destination(String s) {
        class PDestination implements Destination{
            private String label;

            private PDestination(String label) {
                this.label = label;
            }

            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }
}
