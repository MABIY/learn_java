package holding;

import typeinfo.pets.Pet;

import java.util.*;

/**
 * @author lh
 * Followng the example of MultiIterableClass,
 * add reversed() and randomized() methods to
 * NonCollectionSequence.java, as well as marking
 * NonCollectionSequence implement Iterable, and
 * show that all the approaches work in foreach
 * statements
 **/
class NonCollectionSequence32 extends PetSequence implements Iterable<Pet>{
    public Iterable<Pet> reversed() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>() {
                    int current = pets.length - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public Pet next() {
                        return pets[current--];
                    }

                    @Override
                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
    public Iterable<Pet> randomized() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                List<Pet> shuffled = new ArrayList<>(Arrays.asList(pets));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();

            }
        };
    }
    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }

            @Override
            public void remove() { // Not implements
                throw new UnsupportedOperationException();
            }
        };
    }
}
public class E32_MultiIterableNonCollectionSeq {
    public static void main(String[] args) {
        NonCollectionSequence32 nc = new NonCollectionSequence32();
        for (Pet pet : nc.reversed()) {
            System.out.print(pet + " ");
        }
        System.out.println();
        for (Pet pet : nc.randomized()) {
            System.out.print(pet + " ");
        }
        System.out.println();
        for (Pet pet : nc) {
            System.out.print(pet + " ");
        }
    }
}
