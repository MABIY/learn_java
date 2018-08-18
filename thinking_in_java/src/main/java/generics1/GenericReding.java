package generics1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class GenericReding {
    static <T> T readExtract(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());
    // A static method adapts to each call:
    static void f1() {
        Apple a = readExtract(apples);
        Fruit f = readExtract(fruit);
        f = readExtract(apples);
    }

    // if ,however , you have a class then its type is
    // eatablished when the class is instantiated:
    static class Reader<T>{
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruit);
        //Fruit a = fruitReader.readExact(apples); //Error
        //readExtract(List<Fruit>) cannot be applied to (List<Apple>)
    }

    static class CovariantReader<T>{
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<>();
        Fruit f = fruitReader.readCovariant(fruit);
        Fruit a = fruitReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1();f2();
        f3();
    }
}
