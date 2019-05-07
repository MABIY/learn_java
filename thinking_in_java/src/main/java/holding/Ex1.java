package holding;

import java.util.ArrayList;

/**
 * @author lh
 * Create a new class called Gerbil with an int gerbilNumber that's
 * initialized in the constructor. Give it a  method called hop() that
 * displays withc gerbil number that is , and that it's hopping . Create
 * an ArrayList and Gerbil objects to the List. Now use the get() method to move through
 * the List and call hop() for each Gerbil.
 **/
class Gerbil{
    private int gerbilNumebr;

    public Gerbil(int gerbilNumebr) {
        this.gerbilNumebr = gerbilNumebr;
    }

    public void hop() {
        System.out.println("Gerbil " + gerbilNumebr + " hops");
    }

}
public class Ex1 {
    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            gerbils.add(new Gerbil(i));
        }
        // or, alternatively,using foreach syntax:
        for (Gerbil g : gerbils) {
            g.hop();
        }
    }
}
