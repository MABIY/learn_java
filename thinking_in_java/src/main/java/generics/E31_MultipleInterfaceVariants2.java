package generics;

/**
 * @author lh
 * Remove all the generics from
 * MultipleInterfaceVariants.java and modify the
 * code so that the example compiles
 **/

interface Payable31{}

class Employee31 implements Payable31 {}

class Hourly31 extends Employee31 implements Payable31 {
}
public class E31_MultipleInterfaceVariants2 {
    public static void main(String[] args) {
        new Employee31();
        new Hourly31();
    }
}
