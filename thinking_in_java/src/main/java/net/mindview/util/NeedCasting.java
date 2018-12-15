package net.mindview.util;

import org.eclipse.swt.widgets.Widget;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author: liuHua
 * @create: 2018-12-15 20:32
 **/

public class NeedCasting {
	public void f(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream(args[0])
		);
		List<Widget> shapes = (List<Widget>) in.readObject();
	}
}
