package generics;

/**
 * @author: liuHua
 * @create: 2018-12-12 17:15
 **/
interface Payable<T>{}
class Employee implements Payable<Employee>{}

public class MultipleInterfaceVariants {
}
