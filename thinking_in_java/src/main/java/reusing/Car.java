package reusing;

/**
 * @author lh
 * Compositon with public objects
 **/

class CarEngine {
    public void start() {

    }

    public void rev() {

    }

    public void stop() {
    }

    public void service() {
        System.out.println("serivce engine");
    }
}

class Wheel {
    public void inflate(int psi) {

    }
}

class Window {
    public void rollup() {
    }

    public void rolldown() {
    }
}

class Door {
    public Window window = new Window();

    public void open() {

    }

    public void close() {

    }
}

public class Car {
    public CarEngine engine = new CarEngine();
    public Wheel[] wheels = new Wheel[4];
    public Door left = new Door(),
            right = new Door(); //2-door

    public Car() {
        for (int i = 0; i < 4; i++) {
            wheels[i] = new Wheel();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollup();
        car.wheels[0].inflate(72);
        car.engine.service();
    }
}

