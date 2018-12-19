package generics;

/**
 * @author: liuHua
 * @create: 2018-12-19 16:21
 * Removing the generic:code still works
 **/
class CommunicateSimply{
	static void perform(Performs performs) {
		performs.speak();
		performs.sit();
	}
}
public class SimpleDogsAndRobots {
	public static void main(String[] args) {
		CommunicateSimply.perform(new PerformingDog());
		CommunicateSimply.perform(new Robot());
		
	}
}
