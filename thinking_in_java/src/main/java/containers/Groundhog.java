package containers;

/**
 * @author: liuHua
 * @create: 2019-01-10 15:44
 **/

public class Groundhog {
	protected int number;
	
	public Groundhog(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Groundhog{" +
				"number=" + number +
				'}';
	}
}
