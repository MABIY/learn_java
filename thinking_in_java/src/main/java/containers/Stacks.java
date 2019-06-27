package containers;


import java.util.LinkedList;
import java.util.Stack;

import static net.lh.util.Print.print;

/**
 * @author lh
 * Demonstration of Stack Class
 **/
enum Month{
    JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER, NOVEMBER
}
public class Stacks {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (Month m : Month.values()) {
            stack.push(m.toString());
        }
        print("stack = " + stack);
        // Treating a stack as a Vector
        stack.addElement("The last line");
        print("element 5 = " + stack.elementAt(5));
        print("popping elements: ");
        while (!stack.isEmpty()) {
            print(stack.pop() + " ");
        }

        // Using a LinkedList as a Stack
        LinkedList<String> lstack = new LinkedList<>();
        for (Month m : Month.values()) {
            lstack.addFirst(m.toString());
        }
        print("lstack = " + lstack);
        while (!lstack.isEmpty()) {
            print(lstack.removeFirst() + " ");
        }

        // Using the Stack class from
        // the Holding Your Objects Chapter:
        net.mindview.util.Stack<String> stack2 = new net.mindview.util.Stack<>();
        for (Month m : Month.values()) {
            stack2.push(m.toString());
        }
        print("stack2 = " + stack2);
        while (!stack2.empty()) {
            print(stack2.pop() + " ");
        }
    }
}
