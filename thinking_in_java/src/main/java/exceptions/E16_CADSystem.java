package exceptions;

import reusing.CADSystem;

public class E16_CADSystem {
    public static void main(String[] args) {
        CADSystem x = new CADSystem(47);
        try {
            return;
        }finally {
            x.dispose();
        }
    }
}
