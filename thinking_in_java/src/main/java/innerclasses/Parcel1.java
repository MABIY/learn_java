package innerclasses;

import sun.security.krb5.internal.crypto.Des;

public class Parcel1 {
    class Contents{
        private int i = 11;
        private int value() {
            return i;
        }
    }

    class Destination{
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        String readLabel() {
            return label;
        }
    }

    //Using inner classes looks just like
    // using any other class.within Parcel1
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d =  new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }
}
