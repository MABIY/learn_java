package holding;

import reusing.Bath;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Change Exercise 9 in the Polymorphism chapter to use an ArrayList to
 * hold the Rodnets and an Iterator to move through the sequence of Rodnets
 **/
class RandomRodentGenerator{
   private Random rand = new Random();
   public Rodent next() {
      switch (rand.nextInt(3)) {
         default:
         case 0:
            return new Mouse();
         case 1:
            return new Rat();
         case 2:
            return new Squirrel();

      }
   }
}
class Rodent{
   private String name = "Rodnet";
   protected void eat() {
      print("Rodent.eat()");
   }
   protected void run() {
      print("Rodent.run()");
   }
   protected void sleep() {
      print("Rodent.sleep()");
   }

   @Override
   public String toString() {
      return name;
   }
}

class Mouse extends Rodent {
   private String name = "Mouse";
   @Override
   protected void eat() {
      print("Mouse.eat()");
   }

   @Override
   protected void run() {
       print("Mouse.run()");
   }

   @Override
   protected void sleep() {
       print("Mouse.slee()");
   }

   @Override
   public String toString() {
      return name;
   }
}
class Rat extends Rodent{
   private String name = "Rat";

   @Override
   protected void run() {
      print("Rat.run()");
   }

   @Override
   protected void sleep() {
       print("Rat.sleep()");
   }

   @Override
   public String toString() {
      return name;
   }

   @Override
   protected void eat() {
       print("Rat.eat()");
   }
}
class Squirrel extends Rodent{
   private String name = "Squirrel";
   @Override
   protected void eat() {
       print("Squirrel.eat()");
   }

   @Override
   protected void run() {
       print("Squirrel.run()");
   }

   @Override
   protected void sleep() {
       print("Squirrel.sleep()");
   }

   @Override
   public String toString() {
      return name;
   }
}
public class Rodent10 {
   private static RandomRodentGenerator gen = new RandomRodentGenerator();

   public static void main(String[] args) {
      List<Rodent> rodentList = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
         rodentList.add(gen.next());
      }
      Iterator<Rodent> it = rodentList.iterator();
      while (it.hasNext()) {
         Rodent r = it.next();
         print(r + ": ");
         r.eat();
         r.run();
         r.sleep();
      }
   }
}
