package generics;

import typeinfo.pets.Dog;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-19 16:15
 * No latent typing in java
 **/
class PerformingDog extends Dog implements Performs {
	@Override
	public void speak() {
		print("Woof!");
	}
	
	@Override
	public void sit() {
		print("Sitting");
	}
	
	public void reproduce() {}
}

class Robot implements Performs {
	@Override
	public void speak() {
		System.out.println("Click!");
	}
	
	@Override
	public void sit() {
		System.out.println("Clank!");
	}
	
	public void oilChange(){}
}

class Communicate {
	public static <T extends Performs> void perform(T performer) {
		performer.speak();
		performer.sit();
	}
}
public class DogsAndRobots {
	public static void main(String[] args) {
		PerformingDog d = new PerformingDog();
		Robot r = new Robot();
		Communicate.perform(d);
		Communicate.perform(r);
	}
}
