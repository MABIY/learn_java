package holding;


import typeinfo1.pets.Pet;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class CollectionsSequence2 extends PetSequence implements Collection<Pet> {

    static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    static void display(Collection<Pet> pets) {
        for (Pet p : pets) {
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return pets.length;
    }

    @Override
    public boolean isEmpty() {
        return pets.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return false;
        }
        for (int i = 0; i < pets.length; i++) {
            if (o.equals(pets[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[pets.length];
        System.arraycopy(pets, 0, result, 0, pets.length);
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < pets.length) {
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), pets.length);
        }
        T[] result = a;
        System.arraycopy(pets, 0, result, 0, pets.length);
        if (result.length > pets.length) {
            result[pets.length] = null;
        }
        return result;
    }

    @Override
    public boolean add(Pet pet) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> it = c.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean addAll(Collection<? extends Pet> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}

public class E30_CollectionSequence2 {
    public static void main(String[] args) {
        CollectionsSequence2 c = new CollectionsSequence2();
        CollectionsSequence2.display(c);
        CollectionsSequence2.display(c.iterator());
        System.out.println(Arrays.toString(c.toArray(new Pet[0])));
    }
}
