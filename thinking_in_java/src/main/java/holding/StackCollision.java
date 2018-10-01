package holding;

import net.mindview.util.Stack;

public class StackCollision {
    public static void main(String[] args) {
        net.mindview.util.Stack<String> stack = new Stack<>();
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        while (!stack.empty()) {
            System.out.println(stack.pop() + " ");
        }
        System.out.println();
        java.util.Stack<String> stack2 = new java.util.Stack<>();
        for (String s : "My dog has fleas".split(" ")) {
            stack2.push(s);
        }
        while (!stack2.empty()) {
            System.out.println(stack2.pop() + " ");
        }
    }
}
