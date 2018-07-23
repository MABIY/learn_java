package generics1;

interface Payable2{}

class Employee2 implements Payable2{}

class Hourly2 extends Employee2 implements Payable2 {
}
public class E31_MultipleInterfaceVariants2 {
    public static void main(String[] args) {
        new Employee2();
        new Hourly2();
    }
}
