package initialization;

class Test{
    public Test(String s) {
        System.out.println("String constructor: s= " +s);
    }
}
public class E17_ObjectReferences {
    // You cna define teh array as a field in the class:
    Test[] array1 = new Test[5];

    public static void main(String[] args) {
        // Or as a temporary inside main:
        Test[] arrays2 = new Test[5];
    }
}
