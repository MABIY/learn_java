package annotations;


import net.lh.atunit.Test;

/**
 * @author lh
 */
public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @Test
    void testExecute() {
        execute();
    }
}
