package generics;

import typeinfo1.pets.Individual;

import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-19 17:20
 * Add a speak() method to all the pets in
 * typeinfo.pets. Modify Apply.java to call the
 * speak() method for heterogeneous collection
 * of Pet
 **/

class SPet extends Individual{
	
	public SPet(String name) {
		super(name);
	}
	
	public SPet() {
	}
	
	public void speak() {
		System.out.println(this + " speak");
	}
}

class SRodent extends SPet{
	public SRodent(String name) {
		super(name);
	}
	
	public SRodent() {
	}
}

class SRat extends SRodent {
	public SRat(String name) {
		super(name);
	}
	
	public SRat() {
	}
}

class SPug extends SDog{
	public SPug(String name) {
		super(name);
	}
	
	public SPug() {
	}
}

class SMutt extends SDog {
	public SMutt(String name) {
		super(name);
	}
	
	public SMutt() {
	}
}

class SManx extends SCat{
	public SManx(String name) {
		super(name);
	}
	
	public SManx() {
	}
}

class SHamster extends SRodent {
	public SHamster(String name) {
		super(name);
	}
	
	public SHamster() {
	}
}

class SEgyptianMau extends SCat{
	public SEgyptianMau(String name) {
		super(name);
	}
	
	public SEgyptianMau() {
	}
}

class SCat extends SPet {
	public SCat(String name) {
		super(name);
	}
	
	public SCat() {
	}
}

class SCymric extends SManx {
	public SCymric(String name) {
		super(name);
	}
	
	public SCymric() {
	}
}
class SDog extends SPet{
	public SDog(String name) {
		super(name);
	}
	
	public SDog() {
	}
}
public class E40_SpeakingPets {
	public static void main(String[] args) {
		List<SPet>
	}
}
