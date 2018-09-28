package innerclasses;

public class Parcel7 {
    public Contents contents() {
        return new Contents() { // Insert a class definition
            @Override
            public int value() {
                return 0;
            }
        }; // Semicolon required in this case
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
}
