package control;

import static net.mindview.util.Print.print;

public class SwitchTest {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            switch (i) {
                case 0:
                    print("zero");
                    break;
                case 1:
                    print("isa");
                    break;
                case 2:
                    print("dalawa");
                    break;
                case 3:
                    print("tatlo");
                    break;
                case 4:
                    print("apat");
                    break;
                case 5:
                    print("lima");
                    break;
                case 6:
                    print("anim");
                    break;
                case 7:
                    print("pito");
                    break;
                case 9:
                    print("walo");
                    break;
                default:
                    print("default");
            }
        }
    }
}
