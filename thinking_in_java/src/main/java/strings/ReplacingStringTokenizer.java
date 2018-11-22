package strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author: liuHua
 * @create: 2018-11-22 17:05
 **/

public class ReplacingStringTokenizer {
	public static void main(String[] args) {
		String input = "But I'm not dead yet! I feel happy";
		StringTokenizer stoke = new StringTokenizer(input);
		while (stoke.hasMoreElements()) {
		
			System.out.print(stoke.nextToken() + " ");
		}
		
		System.out.println();
		System.out.println(Arrays.toString(input.split(" ")));
		Scanner scanner = new Scanner(input);
		while (scanner.hasNext()) {
			System.out.print(scanner.next() + " ");
		}
	}
}
