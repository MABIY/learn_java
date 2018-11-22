package strings;

import java.util.Arrays;

import static access.util.Print.print;

/**
 * @author: liuHua
 * @create: 2018-11-22 11:48
 **/

public class E14_SplitDemo2 {
	public static void main(String[] args) {
		String input = "This!!unusual use!!of exclamation!!points";
		print(Arrays.toString(input.split("!!")));
		//Only do the first three:
		print(Arrays.toString(input.split("!!",3)));
	}
}
