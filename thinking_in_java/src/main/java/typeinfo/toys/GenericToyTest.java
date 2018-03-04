package typeinfo.toys;

public class GenericToyTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<FancyToy> ftClass = FancyToy.class;
        // Produces exact type:
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        // this won't compile
        // Class<Toy> up2 = ftClass.getSuperclass();
        // Only produces Object
        Object object = up.newInstance();

    }
}
