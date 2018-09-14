package initialization;

import java.sql.SQLOutput;

public class OverloadingVarargs2 {
    static void f(int i,Character... args) {
        System.out.println("first");
    }

    static void f(char c, Character... args) {
        System.out.println("second");
    }


    public static void main(String[] args) {
        f('a','a');
    }
}
