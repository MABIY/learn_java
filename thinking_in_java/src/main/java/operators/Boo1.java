package operators;

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Relational and logical operators
 **/
public class Boo1 {
    public static void main(String[] args) {
        Random rand = new Random(47);
        int i = rand.nextInt(100);
        int j = rand.nextInt(100);
        print("i = " + i);
        print("j = " + j);
        print("i > j is " + (i > j));
        print("i < j is " + (i < j));
        print("i >= j is " + (i >= j));
        print("i <= j is " + (i <= j));
        print("i == j is " + (i == j));
        print("i != j is " + (i !=j ));
        //Threating an int as a boolean is not legal java:
//        print("i && j is " + (i && j));
//        print("i || j is " + (i || j));
//        print("!i is " + !i);
        print("(i < 10 ) && (j < 10) is"
                + ((i < 10) && (j < 10)));
        print("(i < 10 ) || (j < 10) is"
                + ((i < 10) || (j < 10)));
    }
}
