package holding;

import java.util.ArrayList;

class Gerbil{
    private final int gerbilNumber;

    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    @Override
    public String toString() {
        return "Gerbil{" +
                "gerbilNumber=" + gerbilNumber +
                '}';
    }

    public void hop() {
        System.out.println(this + " is hopping");
    }
}
public class E01_Gerbil {
    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            gerbils.add(new Gerbil(i));
        }
        for (int i = 0; i < gerbils.size(); i++) {
            gerbils.get(i).hop();
        }
    }
}
