package net.mindview.util;

/**
 * @author: liuHua
 * @create: 2018-12-15 21:27
 **/

class Hamster extends ComparablePet implements Comparable<ComparablePet> {
	@Override
	public int compareTo(ComparablePet o) {
		return 0;
	}
}

class Gecko extends ComparablePet {
	public int compareTo(ComparablePet arg) {
		return 0;
	}
}

