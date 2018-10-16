package exceptions;

public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            System.out.println(test());
            throw new RuntimeException();
        }finally {
            // Using 'return' inside the finally block
            // will silence any thrown exception
            return;
        }
    }

    static int a = 1;
    static int b = 2;
    public static int test() {
        try {
            a = 1;
            throw new RuntimeException();
        }finally {
            return b;
        }
    }
}
