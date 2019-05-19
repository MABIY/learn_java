package typeinfo.toys;

/**
 * @author lh
 **/
class Building{
}

class House extends Building {}
public class ClassCasts {
    public static void main(String[] args) {
        House b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House)b; // ... or just od this
    }
}
