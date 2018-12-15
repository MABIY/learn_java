package net.mindview.util;

import org.eclipse.swt.widgets.Widget;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-15 20:35
 **/

public class ClassCasting {
	public void f(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(args[0])
		);
		
		//Won't Compile
		// List<Widget> lw1 = List<Widget>.class.cast(in.readObject());
		List<Widget> lw2 = List.class.cast(in.readObject());
	}
}
