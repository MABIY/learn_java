package strings;

/**
 * @author: liuHua
 * @create: 2018-11-18 20:18
 **/

class WaterSource{
	private String s;
	
	public WaterSource() {
		System.out.println("WaterSource()");
		s = "Constructed";
	}
	
	@Override
	public String toString() {
		return s;
	}
}
public class SprinklerSystem1 {
	private String valve1,valve2,valve3, valve4;
	private WaterSource source = new WaterSource();
	private int i;
	private float f;
	// appears to create only one StringBuilder:(using javap -c)
	
	
	@Override
	public String toString() {
		return "SprinklerSystem1{" +
				"valve1='" + valve1 + '\'' +
				", valve2='" + valve2 + '\'' +
				", valve3='" + valve3 + '\'' +
				", valve4='" + valve4 + '\'' +
				", source=" + source +
				", i=" + i +
				", f=" + f +
				'}';
	}
	
	public static void main(String[] args) {
		SprinklerSystem1 sprinklers = new SprinklerSystem1();
		System.out.println(sprinklers);
	}
}
