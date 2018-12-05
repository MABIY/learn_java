package generics.coffee;

import generics.util.Generator;

import java.util.Iterator;
import java.util.Random;

/**
 * @author: liuHua
 * @create: 2018-12-05 11:20
 * Following the form of the Coffee example,create
 * a hierarchy of StoryCharacters from your favorite movie,
 * dividing them into GoodGuys and BadGuys.
 * Create a generator for StoryCharacters, following
 * the form of CoffeeGenerator.
 **/

class StoryCharacter{
	private static long counter;
	private final long id = counter++;
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
}

class GoodsGuy extends StoryCharacter {
	@Override
	public String toString() {
		return super.toString() + " is a good guy";
	}
}

class BadGuy extends StoryCharacter {
	@Override
	public String toString() {
		return super.toString() + " is a bad guy";
	}
}

class Morton extends BadGuy {

}

class Frank extends BadGuy{}

class Harmonica extends GoodsGuy{}

class Cheyenne extends GoodsGuy{}

class CharacterGenerator implements Generator<StoryCharacter>, Iterable<StoryCharacter> {
	private Class<?>[] types = {
			Morton.class, Frank.class,
			Harmonica.class, Cheyenne.class
	};
	
	private static Random rand = new Random(47);
	private int size = 0;
	
	public CharacterGenerator() {
	}
	
	public CharacterGenerator(int size) {
		this.size = size;
	}
	
	@Override
	public StoryCharacter next() {
		try {
			return (StoryCharacter) types[rand.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	class CharacterIterator implements Iterator<StoryCharacter> {
		int count = size;
		@Override
		public boolean hasNext() {
			return count > 0;
		}
		
		@Override
		public StoryCharacter next() {
			count--;
			return CharacterGenerator.this.next();
		}
		
		@Override
		public void remove() { // Not implemented
			throw new UnsupportedOperationException("remove");
		}
	}
	
	@Override
	public Iterator<StoryCharacter> iterator() {
		return new CharacterIterator();
	}
}
public class E08_CharacterGenerator {
	public static void main(String[] args) {
		CharacterGenerator gen = new CharacterGenerator();
		for (int i = 0; i < 7; i++) {
			System.out.println(gen.next());
		}
		for (StoryCharacter p : new CharacterGenerator(7)) {
			System.out.println(p);
		}
	}
}
