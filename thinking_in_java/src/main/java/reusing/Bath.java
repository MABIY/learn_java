package reusing;

import static access.util.Print.print;

class Soap {
    private String s;

    public Soap() {
        print("Soap()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

/**
 * @author lh
 */
public class Bath {
    private String // Initializeing at point of definition:
            s1 = "Happey",
            s2 = "Happy",
            s3, s4;

    private Soap castille;
    private int i;
    private float toy;

    public Bath() {
        print("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castille = new Soap();
    }

    // Instance initialization:
    {
        i = 47;
    }

    @Override
    public String toString() {
        return "Bath{" +
                "s1='" + s1 + '\'' +
                ", s2='" + s2 + '\'' +
                ", s3='" + s3 + '\'' +
                ", s4='" + s4 + '\'' +
                ", castille=" + castille +
                ", i=" + i +
                ", toy=" + toy +
                '}';
    }

    public static void main(String[] args) {
        Bath b = new Bath();
        print(b);
    }
}

