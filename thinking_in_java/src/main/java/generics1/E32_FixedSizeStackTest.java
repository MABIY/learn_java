package generics1;

public class E32_FixedSizeStackTest{
    public static void main(String[] args) {
        FixedSizeStack<Integer> stack = new FixedSizeStack<>(1);
        stack.push(1);
        System.out.println(stack.pop());
        try {
            stack.pop();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }

        stack = new FixedSizeStack<>(1);
        stack.push(2);
        try {
            stack.push(2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
    }
}
