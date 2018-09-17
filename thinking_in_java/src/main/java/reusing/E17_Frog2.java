package reusing;

class Frog2 extends Amphibian{
    @Override
    public void moveInWater() {
        System.out.println("Frog swimming");
    }

    @Override
    public void moverOnLand() {
        System.out.println("Frog jumping");
    }
}
public class E17_Frog2 {
    public static void main(String[] args) {
        Amphibian a = new Frog2();
        a.moverOnLand();
        a.moveInWater();
    }
}
