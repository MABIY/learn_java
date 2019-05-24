package typeinfo;

import net.lh.util.Null;

/**
 * @author lh
 **/
public class Person {
    public final String first;
    public final String last;
    public final String address;
    // etc.

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }

    public static class NullPerson extends Person implements Null {
        public NullPerson(String first, String last, String address) {
            super(first, last, address);
        }

        public NullPerson() {
            super(null, null, null);
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }

    public static final Person NULL = new NullPerson();
}
