package exceptions;

import polymorphism.Frog;

//Frog.dispose is protected ,cannot be called directly
class Frog2 extends Frog {
    @Override
    protected void dispose() {
        super.dispose();
    }
}
public class E17_Frog {
    public static void main(String[] args) {
        Frog2 frog = new Frog2();
        try {
            // No return in the middle
        }finally {
            frog.dispose();
        }
        frog = new Frog2();
        try {
            //With return in the middle
            return;
        }finally {
            frog.dispose();
       }

    }
}
