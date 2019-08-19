package enumerated;

import net.lh.util.Enums;

/**
 * @author lh
 * Add a new Course to Course.java and demonstrate
 * that it works in Meal.java
 */
interface Food3{
    enum Appetizer implements Food3{
        SALAD,SOUP,SPRING_ROLLS;
    }

    enum Beverage implements Food3{
        BEER,VINE,JUICE,COLA,WATER;
    }
    enum MainCourse implements Food3{
        LASAGNE,BURRITO,PAD_THAI,
        LENTILS,HUMMOUS,VINDALOO;
    }

    enum Dessert implements Food3 {
        TIRAMISU,GELATO,BLACK_FOREST_CAKE,
        FRUIT,CREME_CARAMEL;
    }
    enum Coffee implements Food3{
        BLACK_COFFEE,DECAF_COFFEE,ESPRESSO,
        LATTE,CAPPUCCINO,TEA,HERB_TEA
    }
}
enum Course3{
    APPETIZER(Food3.Appetizer.class),
    MAINCOURSE(Food3.MainCourse.class),
    BEVERAGE(Food3.Beverage.class),
    DESSERT(Food3.Dessert.class),
    COFFEE(Food3.Coffee.class);
    private Food3[] values;

    Course3(Class<? extends Food3> kind) {
        values = kind.getEnumConstants();
    }

    public Food3 randomSelection() {
        return Enums.random(values);
    }
}
public class E03_Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course3 course : Course3.values()) {
                Food3 food3 = course.randomSelection();
                System.out.println(food3);
            }
            System.out.println("---");
        }
    }
}
