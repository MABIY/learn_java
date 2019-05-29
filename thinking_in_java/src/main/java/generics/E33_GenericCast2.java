package generics;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * @author lh
 * Repair GenericCast.java using an ArrayList
 **/
class FullStackException extends RuntimeException {
}

class FixedSizeStack2<T>{
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
        FixedSizeStack2<String> strings = new FixedSizeStack2<>(SIZE);
        for (String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }
        for (int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            print(s + " ");
        }
        print();
        try {
            strings.pop();
        } catch (EmptyStackException e) {
            print("Stack is empty");
        }
        strings = new FixedSizeStack2<>(1);
        strings.push("A");

        try {
            strings.push("B");
        } catch (FullStackException e) {
            print("Stack is full");
        }
    }
}
