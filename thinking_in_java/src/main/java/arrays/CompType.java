package arrays;

import generics.util.Generator;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Random;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-12-26 16:26
 **/

public class CompType implements Comparable<CompType> {
	int i;
	int j;
	private static int count = 1;
	
	public CompType(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	@Override
	public int compareTo(@NotNull CompType o) {
		return (i < o.i ? -1 : (i == o.i ? 0 : 1));
	}
	
	private static Random r = new Random(47);
	
	public static Generator<CompType> generator() {
		return new Generator<CompType>() {
			@Override
			public CompType next() {
				return new CompType(r.nextInt(100), r.nextInt(100));
			}
		};
	}
	
	@Override
	public String toString() {
		String result = "[i = " + i + ", j = " + j + "]";
		if (count++ % 3 == 0) {
			result += "\n";
		}
		return result;
	}
	
	public static void main(String[] args) {
		CompType[] a = Generated.array(new CompType[12], generator());
		print("before sorting:");
		print(Arrays.toString(a));
		Arrays.sort(a);
		print("after sorting");
		print(Arrays.toString(a));
	}
}
