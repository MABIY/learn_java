package object;

public class Rainbow {
    public static void main(String[] args) {
        AllTheColorOfTheRainbow atc = new AllTheColorOfTheRainbow();
        System.out.println("atc.anIntegerRepresentingColors = " + atc.anIntegerRepresentingColors);
        atc.changeColor(7);
        atc.changeTheHueOfTheColor(77);
        System.out.println("After color change, atc.anIntgerRepresentingColors = " +atc.anIntegerRepresentingColors );
        System.out.println("atc.hue = " + atc.hue);
    }

}
class AllTheColorOfTheRainbow {
    int anIntegerRepresentingColors = 0;
    int hue = 0;

    void changeTheHueOfTheColor(int newHue) {
        hue = newHue;
    }

    int changeColor(int newColor) {
        return anIntegerRepresentingColors = newColor;
    }
}

