import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;

import javax.sql.rowset.spi.TransactionalWriter;
import java.applet.Applet;
import java.io.File;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lh
 */

@FunctionalInterface
interface Predicate<T>{
   public  boolean test();
}
class Apple{

    public  boolean isGreenApple1() {
        return "green".equals("1");
    }

    public static boolean isHeavyApple() {

        // return apple.getWeight() > 150;
        return true;
    }
    public Integer getWeight() {
        return 1;
    }

    public String getColor() {
        return "fds";
    }

}
public class Test {

    public    boolean isGreenApple() {
        return "green".equals("1");
    }
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public  static List<Apple> filterApples(Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        Apple apple = new Apple();
        // if (p.test(apple)) {
        //     result.add(apple);
        // }
        // for (Apple apple : inventory) {
        //     if (p.test(apple)) {
        //         result.add(apple);
        //     }
        // }

        return result;
    }

    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        // List<Apple> inventory = new ArrayList<>();
        // filterApples(inventory, Apple::isGreenApple1);

        // List<Apple> apples = new Test().filterApples(Apple::isGreenApple1);
        List<Apple> apples = new Test().filterApples(Apple::isHeavyApple);
        // List<Apple> t = new Test().filterApples(Apple::isGreenApple1); //lhtd 未什么不行
        // List<Apple> heavyApples= inventory.stream().filter((Apple a)->a.getWeight()>150).collect(Collectors.toList());

    }

    public void test() {
        List<Apple> inventory = new ArrayList<>();
        // filterApples(inventory, Apple::isGreenApple1);

    }

}
