package typeinfo1;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = Integer.class; //Same thing
        intClass = double.class;
        //genericIntClass = double.class;
    }
}
