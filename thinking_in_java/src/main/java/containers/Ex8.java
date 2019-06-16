package containers;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static net.lh.util.Print.print;

/**
 * @author lh
 **/
class SList8<E>{
    private Link<E> headLink = new Link<>(null);
    SListIterator8<E> iterator() {
        return new SListIterator8<>(headLink);
    }

    @Override
    public String toString() {
        if (headLink.next == null) {
            return "Slist: []";
        }
        print("SList: [");
        SListIterator8<E> it = this.iterator();
        StringBuilder s = new StringBuilder();
        while (it.hasNext()) {
            s.append(it.next() + (it.hasNext() ? ", " : ""));
        }
        return s + "]";
    }
}
class SListIterator8<E>{
    Link<E> current;
    Link<E> parent;

    public SListIterator8(Link<E> current) {
        this.current = current;
    }
    public boolean hasNext() {
        return current.next != null;
    }

    public Link<E> next() {
        parent = current;
        current = current.next;
        return current;
    }

    public void insert(E e) {
        current.next = new Link<>(e, current.next);
        current = current.next;
    }

    public void remove() {
        if (current.next != null) {
            parent = current.next.next;
        }
    }


}
class Link<E>{
    E e;
    Link<E> next;

    Link(E e, Link<E> next) {
        this.e = e;
        this.next = next;
    }

    public Link(E e) {
        this.e = e;
    }

    @Override
    public String toString() {
        if (e == null) {
            return null;
        }
        return e.toString();
    }
}
public class Ex8 {
    public static void main(String[] args) {
        SList8<String> sl = new SList8<>();
        print(sl);
        SListIterator8<String> slit = sl.iterator();
        slit.insert("One");
        slit.insert("Two");
        slit.insert("Three");
        print(slit.hasNext());
        print(sl);
        slit = sl.iterator();
        slit.insert("Four");
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
