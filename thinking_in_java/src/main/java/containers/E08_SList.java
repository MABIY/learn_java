package containers;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Create a generic, singly-linked list class
 * called SList, which, to keep things simple
 * does not implement the List interface, Each Link
 * object in the list should contain a reference to
 * the next element inthe list but not the previous
 * one (LinkedList, in contrast, is a double-linked list,
 * which means it maintains links in both directions).
 * Create your own SListIterator which,
 * again for simplicity, does not implement ListIterator.
 * The only method in Slist other than toString()
 * should be iterator(),which produces an SListIterator.
 * The only way to insert and remove elements from an SList
 * is through SLIstIterator.
 * Write code to demonstrate SList.
 **/
interface SListIterator<T>{
    boolean hasNext();

    T next();

    void remove();

    void add(T element);
}

class SList<T>{
    // Utilization of the 'Null Object' pattern
    private final Link<T> header = new Link<T>(null, null);
    SList() {
        header.next = header;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for (SListIterator<T> it = iterator(); it.hasNext(); ) {
            T element = it.next();
            buf.append(element == this ? "(this SList)" : String.valueOf(element));
            if (it.hasNext()) {
                buf.append(", ");
            }
        }
        buf.append("]");
        return buf.toString();
    }

    public SListIterator<T> iterator() {
        return new SListIteratorImpl();
    }
    private static class Link<T>{
        T element;
        Link<T> next;

        public Link(T element, Link<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    private class SListIteratorImpl implements  SListIterator<T>{
        private Link<T> lastReturned = header;
        private Link<T> next;

        public SListIteratorImpl() {
            next = header.next;
        }

        @Override
        public boolean hasNext() {
            return next != header;
        }

        @Override
        public T next() {
            if (next == header) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            return lastReturned.element;
        }

        @Override
        public void remove() {
            if (lastReturned == header) {
                throw new IllegalStateException();
            }
            // Find an element before the last returned one
            for (Link<T> curr = header; ; curr = curr.next) {
                if (curr.next == lastReturned) {
                    curr.next = lastReturned.next;
                    break;
                }
            }
            lastReturned = header;
        }

        @Override
        public void add(T element) {
            lastReturned = header;
            Link<T> newLink = new Link<T>(element, next);
            if (header.next == header) { // Empty list
                header.next = newLink;
            } else {
                // Find an element before the one pointed by 'next'
                for (Link<T> curr = header; ; curr =curr.next) {
                    if (curr.next == next) {
                        curr.next = newLink;
                        break;
                    }
                }
            }
        }
    }
}
public class E08_SList {
    public static void main(String[] args) {
        // First, show some use cases for SListIterator
        print("Demonstrating SListIterator...");
        SList<String> sl = new SList<>();
        print(sl);
        SListIterator<String> slit = sl.iterator();
        slit.add("One");
        slit.add("Two");
        slit.add("Three");
        print(slit.hasNext());
        print(sl);
        slit = sl.iterator();
        slit.add("Four");
        for (; slit.hasNext(); ) {
            print(slit.next());
        }
        print(sl);
        slit = sl.iterator();
        print(slit.next());
        slit.remove();
        print(slit.next());
        print(sl);
        // Now , show teh same use cases for ListIterator, too
        print("\nDemonstrating ListIterator...");
        List<String> l = new ArrayList<>();
        print(l);
        ListIterator<String> lit = l.listIterator();
        lit.add("One");
        lit.add("Two");
        lit.add("Three");
        print(lit.hasNext());
        print(l);
        lit = l.listIterator();
        lit.add("Four");
        for (; lit.hasNext(); ) {
            print(lit.next());
        }
        print(l);
        lit = l.listIterator();
        print(lit.next());
        lit.remove();
        print(lit.next());
        print(l);
    }
}
