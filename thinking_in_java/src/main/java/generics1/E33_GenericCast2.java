package generics1;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

class FullStackException extends RuntimeException {
}

class FixedSizeStack2<T> {
    private int index;
    private final int size;
    private final List<T> storage;

    public FixedSizeStack2(int size) {
        storage = new ArrayList<>(size);
        this.size = size;
    }

    public void push(T item) {
        if (index < size) {
            index++;
            storage.add(item);
        } else {
            throw new FullStackException();
        }
    }

    public T pop() {
        if (index > 0) {
            return storage.get(--index);
        }
        throw new EmptyStackException();
    }
}
public class E33_GenericCast2 {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack2<String> string2 = new FixedSizeStack2<>(SIZE);
        for (String s : "A B C D E F G H I J".split(" ")) {
            string2.push(s);
        }
        for (int i = 0; i < SIZE; i++) {
            String s = string2.pop();
            System.out.println(s + " ");
        }

        System.out.println();
        try {
            string2.pop();
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty");
        }
        string2 = new FixedSizeStack2<>(1);
        string2.push("A");
        try {
            string2.push("B");
        } catch (FullStackException e) {
            System.out.println("Stack is full");
        }
    }
}
