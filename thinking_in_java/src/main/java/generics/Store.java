package generics;

import generics.util.Generator;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author: liuHua
 * @create: 2018-12-06 16:12
 * Building up a complex model using generic containers
 **/
class Product {
	private final int id;
	private String description;
	private double price;
	
	public Product(int id, String description, double price) {
		this.id = id;
		this.description = description;
		this.price = price;
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", description='" + description + '\'' +
				", price=" + price +
				'}';
	}
	
	public static Generator<Product> generator = new Generator<Product>() {
		private Random rand = new Random(47);
		
		@Override
		public Product next() {
			return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000.0) + 0.99);
		}
	};
}

class Shelf extends ArrayList<Product> {
	public Shelf(int nProducts) {
		Generators.fill(this, Product.generator, nProducts);
	}
}

class Aisle extends ArrayList<Shelf> {
	public Aisle(int nShelves, int nProducts) {
		add(new Shelf(nProducts));
	}
}
class CheckoutStand{}

class Office{}

public class Store extends ArrayList<Aisle>{
	private ArrayList<CheckoutStand> checkouts = new ArrayList<>();
	private Office office = new Office();
	
	public Store(int nAisles, int nShelves, int nProducts) {
		for (int i = 0; i < nAisles; i++) {
			add(new Aisle(nShelves, nProducts));
		}
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Aisle a : this) {
			for (Shelf s : a) {
				for (Product p : s) {
					result.append(p);
					result.append(System.lineSeparator());
				}
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Store(14, 15, 10));
	}
}
