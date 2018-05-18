package initialization;

class Rock2 {
    public Rock2(int i) {
        System.out.println("Rock "  + i + " ");
    }
}
public class SimpleConstructor2 {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            new Rock2(i);
        }
    }
}
