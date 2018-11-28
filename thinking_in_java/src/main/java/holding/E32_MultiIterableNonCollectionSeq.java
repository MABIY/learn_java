package holding;

import typeinfo1.pets.Pet;

import java.util.*;

class NonCollectionSequence32 extends PetSequence implements Iterable<Pet> {
    public Iterable<Pet> reversed() {
        return new Iterable<Pet>() {
            @Override
            public Iterator<Pet> iterator() {
                return new Iterator<Pet>(){
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
                    public void remove() {
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
            public void remove() { // Not implement
                throw new UnsupportedOperationException();
            }

            @Override
            public Pet next() {
                return pets[index++];
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
