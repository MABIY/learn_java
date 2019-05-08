package holding;

import net.lh.util.Stack;

/**
 * @author lh
 * Stacks are often used to evaluate expressions in programming
 * languages. Using net.mindview.util.Stack,evaluate the following
 * expression,where '+' means "push the following letter onto the stack",
 * and '-' means "pop hte top of the statck and print it":
 * "+U+n+c---+e+r+t---+a+i+n+t+y---+ -+r+u--+l+e+s---"
 **/
public class Ex15 {
    private final static Stack<Character> stack = new Stack<>();

    private static void evaluate(String expr) {
        char data[] = expr.toCharArray();
        for (int i = 0; i < data.length;) {
            switch (data[i++]) {
                case '+':
                    stack.push(data[i++]);
                    break;
                case '-':
                    System.out.println(stack.pop());
            }
        }
    }
    public static void main(String[] args) {
        evaluate("+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---");
    }
}
