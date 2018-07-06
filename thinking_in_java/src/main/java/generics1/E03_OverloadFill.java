package generics1;

import generics1.coffee.Coffee;
import generics1.coffee.CoffeeGenerator;
import generics1.coffee.Fibonacci;
import generics1.util.Generator;
import lh.com.util.CountingGenerator;

import java.util.*;

public class E03_OverloadFill {
    public static <T> List<T> fill(List<T> list, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            list.add(gen.next());
        }
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
        for (Coffee c : coffeeList) {
            System.out.println(c);
        }

        Queue<Integer> iQueue = fill((Queue<Integer>)new LinkedList<Integer>(), new Fibonacci(), 12);

        for (int i : iQueue) {
            System.out.println(i + " ");
        }

        System.out.println();

        LinkedList<Character> cLList = fill(new LinkedList<>(), new CountingGenerator.Character(), 12);
        for (char ch : cLList) {
            System.out.println(ch);
        }

        System.out.println();
        Set<Boolean> bSet = fill(new HashSet<>(), new CountingGenerator.Boolean(), 10);
        for (Boolean b : bSet) {
            System.out.println(b);
        }

    }
}

