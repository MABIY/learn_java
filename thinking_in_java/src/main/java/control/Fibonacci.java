package control;

/**
 * @author lh
 * A fibonacci sequence is the sequence
 **/
public class Fibonacci {
    int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return (fib(n - 2) + fib(n - 1));
    }

    public static void main(String[] args) {
        args = new String[]{"7"};
        Fibonacci f = new Fibonacci();
        int k = Integer.parseInt(args[0]);
        System.out.println("First " + k+ " Fibonacci number(s): ");
        for (int i = 0; i < k; i++) {
            System.out.println(f.fib(i));
        }
    }
}
