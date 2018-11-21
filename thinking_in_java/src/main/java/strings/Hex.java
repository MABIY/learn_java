package strings;

import net.mindview.util.BinaryFile;

import javax.swing.text.Position;
import java.io.File;
import java.io.IOException;

/**
 * @author: liuHua
 * @create: 2018-11-21 10:36
 **/

public class Hex {
	public static String format(byte[] data) {
		StringBuilder result = new StringBuilder();
		int n = 0;
		for (byte b : data) {
			if (n % 16 == 0) {
				result.append(String.format("%05X: ", n));
			}
			result.append(String.format("%02X ", b));
			n++;
			if (n % 16 == 0) {
				result.append("\n");
			}
		}
		result.append("\n");
		return result.toString();
	}
	
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			// Test by displaying this class file:
			System.out.println(
					format(BinaryFile.read("/home/lh/project/learn_java/thinking_in_java/target/classes/strings/Hex.class"))
			);
		} else {
			System.out.println(
					format(BinaryFile.read(new File(args[0])))
			);
		}
	}
}
