package strings;

import java.util.Scanner;

/**
 * @author: liuHua
 * @create: 2018-11-22 16:24
 **/

public class ScannerDelimiter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner("12, 42, 78, 99, 42");
		scanner.useDelimiter("\\s*,\\s*");
		while (scanner.hasNextInt()) {
			System.out.println(scanner.nextInt());
		}
	}
}
