package access.foreign;

/**
 * @author lh
 * Composition for code reuse.
 **/
class WaterSource{
    private String s;

    public WaterSource() {
        System.out.println("WaterSource");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}
public class SprinklerSystem {
    private String value1,value2,value3, value4;

    private WaterSource source = new WaterSource();

    private int i;
    private float f;

    @Override
    public String toString() {
        return "SprinklerSystem{" +
                "value1='" + value1 + '\'' +
                ", value2='" + value2 + '\'' +
                ", value3='" + value3 + '\'' +
                ", value4='" + value4 + '\'' +
                ", source=" + source +
                ", i=" + i +
                ", f=" + f +
                '}';
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklerSystem = new SprinklerSystem();
        System.out.println(sprinklerSystem);
    }
}
