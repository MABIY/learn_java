package reusing;

class Amphibian{
    public void moveInWater() {
        System.out.println("Moving in Water");
    }

    public void moverOnLand() {
        System.out.println("Moving on Lang");
    }
}

class Frog extends Amphibian {
}
public class E16_Frog {
    public static void main(String[] args) {
        Amphibian a = new Frog();
        a.moveInWater();
        a.moverOnLand();
    }
}
