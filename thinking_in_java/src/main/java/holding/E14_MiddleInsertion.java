package holding;

import java.util.LinkedList;
import java.util.ListIterator;

public class E14_MiddleInsertion {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        ListIterator<Integer> it = list.listIterator();
        for (int i = 0; i < 10; i++) {
            it.add(i);
            if (i % 2 == 0) {
                it.previous();
            }
        }
        System.out.println(list);
    }
}
