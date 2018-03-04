package typeinfo;

class Building {

}

class House extends Building {
   public void a() {
       System.out.println("a");
   }
}
public class ClassCasts {
    public static void main(String[] args) {
        Building b = new Building();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House) b; // or ... just do this

    }
}
