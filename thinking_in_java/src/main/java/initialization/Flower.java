package initialization;

public class Flower {
    int petalCount = 0;
    String s = "initial value";

    Flower(int petals) {
        petalCount = petals;
        System.out.println("Constructor w/ int arg only. petalCount= " + petals);
    }

    Flower(String ss) {
        System.out.println("Constructor w/  String arg only s  = " + ss);
    }

    Flower(String s, int petals) {
        this(petals);
        this.s = s;
        System.out.println("String & int args");
    }
    Flower() {
        this("hi", 47);
        System.out.println("default constr4uctor(no args)");
    }
    void printPetalCount() {
        // !this(11); // not inside non-constructor
        System.out.println("petalCount = " + petalCount + " s= " + s);
    }

    public static void main(String[] args) {
        Flower x = new Flower();
        x.printPetalCount();
    }
}
