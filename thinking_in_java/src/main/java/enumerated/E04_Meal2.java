package enumerated;

import enumerated.menu.Food;
import net.lh.util.Enums;

/**
 * @author lh
 * Repeat the above exercise for Meal2.java
 */
enum Meal2{
    APPETIZER(Food3.Appetizer.class),
    MAINCOURSE(Food3.MainCourse.class),
    BEVERAGE(Food3.Beverage.class),
    DESSERT(Food3.Dessert.class),
    COFFEE(Food3.Coffee.class);
    private Food3[] values;

    Meal2(Class<? extends Food3> kind) {
        values = kind.getEnumConstants();
    }

    public interface Food3{
        enum Appetizer implements Food3{
            SALAD,SOUP,SPRING_ROLLS;
        }

        enum MainCourse implements Food3 {
            LASAGNE,BURRITO,PAD_THAI,
            LENTILS,HUMMOUS,VINDALOO;
        }
        enum Beverage implements Food3{
            BEER,VINE,JUICE,COLA,WATER;
        }

        enum Dessert implements Food3{
            TIRAMISU,GELATO,BLACK_FOREST_CAKE,
            FRUIT,CREME_CARAMEL;
        }
        enum Coffee implements Food3{
            BLACK_COFFEE,DECAF_COFFEE,ESPRESSO,
            LATTE,CAPPUCCINO,TEA,HERB_TEA;
        }
    }

    public Food3 randomSelection() {
        return Enums.random(values);
    }
}

public class E04_Meal2 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Meal2 meal : Meal2.values()) {
                Meal2.Food3 food3 = meal.randomSelection();
                System.out.println(food3);
            }
            System.out.println("---");
        }
    }
}
