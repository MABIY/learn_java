package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.print;

/**
 * @author lh
 **/

class House implements Serializable {

    private static final long serialVersionUID = 7242980887187354737L;
}

class Animal implements Serializable {

    private static final long serialVersionUID = 4227338598794659211L;

    private String name;

    private House preferredHouse;

    public Animal(String name, House preferredHouse) {
        this.name = name;
        this.preferredHouse = preferredHouse;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", preferredHouse=" + preferredHouse +
                '}';
    }
}

public class MyWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Bosco the dog", house));
        animals.add(new Animal("Ralph the hamster", house));
        animals.add(new Animal("Molly the cat", house));
        List<Animal> animalsp = new ArrayList<>();
        animalsp.add(new Animal("Bosco the dog", house));
        animalsp.add(new Animal("Ralph the hamster", house));
        animalsp.add(new Animal("Molly the cat", house));
        print("animals: " + animals);
        ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
        ObjectOutputStream oi = new ObjectOutputStream(buf1);
        oi.writeObject(animals);
        oi.writeObject(animalsp); // Write a 2nd set
        // Write to a different stream:
        ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
        ObjectOutputStream o2 = new ObjectOutputStream(buf2);
        o2.writeObject(animals);
        // Now get them back:
        ObjectInputStream in1 = new ObjectInputStream(
                new ByteArrayInputStream(buf1.toByteArray())
        );
        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(buf2.toByteArray())
        );
        List animals1 = (List) in1.readObject(),
                animals2 = (List) in1.readObject(),
                animals3 = (List) in2.readObject();
        print("animals1: " + animals1);
        print("animals2: " + animals2);
        print("animals3: " + animals3);

    }
}
