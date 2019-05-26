package generics;

import generics.coffee.Coffee;
import generics.coffee.CoffeeGenerator;
import net.lh.util.CountingGenerator;
import net.lh.util.Generator;

import java.util.*;

/**
 * @author lh
 * Oveerload the fill() method so the arguements
 * and return  tyeps are the specificc subteypes of
 * Collecion: List,Queue and set, This way, you
 * don't lose the type of container, Can you overload
 * to distinguish between List and LinkedList?
 **/
public class E13_OverloadedFill {
    public static <T> List<T> fill(List<T> list, Generator<T> gen, int n) {
        list.add(gen.next());
        return list;
    }

    public static <T> Queue<T> fill(Queue<T> queue, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            queue.add(gen.next());
        }
        return queue;
    }

    public static <T> LinkedList<T> fill(LinkedList<T> llist, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            llist.add(gen.next());
        }
        return llist;
    }

    public static <T> Set<T> fill(Set<T> set, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            set.add(gen.next());
        }
        return set;
    }

    public static void main(String[] args) {
        List<Coffee> coffeeList = fill(new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee coffee : coffeeList) {
            System.out.println(coffee);
        }
        Queue<Integer> iQueue = fill((Queue<Integer>)new LinkedList<Integer>(), new Fibonacci(), 12);
        for (Integer integer : iQueue) {
            System.out.println(integer + " ");
        }
        System.out.println();
        LinkedList<Character> cLList = fill(new LinkedList<>(), new CountingGenerator.Character(), 12);
        for (Character character : cLList) {
            System.out.println(character);
        }
        Set<Boolean> bSet = fill(new HashSet<>(), new CountingGenerator.Boolean(), 12);
        for (Boolean aBoolean : bSet) {
            System.out.println(aBoolean);
        }
    }
}
