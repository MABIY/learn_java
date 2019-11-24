import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 **/
public class Apple {
    private String color;
    private Integer weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        Filter.filterApples(inventory,new Filter()::bb);
    }
}

class Filter{

    public  boolean bb(Apple apple) {
        return true;
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

interface Predicate<T>{
    boolean test(T t);
}
