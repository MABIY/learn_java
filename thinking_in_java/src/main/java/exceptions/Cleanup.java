package exceptions;

public class Cleanup {
    public static void main(String[] args) {
        try {
            InputFile in = new InputFile("/home/lh/project/learn_java/thinking_in_java/src/main/java/exceptions/Cleanup.java");
            try {
                String s;
                int i = 1;
                while ((s = in.getLine()) != null) {
                    //Perform line-by-line processing here...
                }
            } catch (Exception e) {
                System.out.println("Caught Exception in main");
                e.printStackTrace(System.out);
            }finally {
                in.dispose();
            }
        } catch (Exception e) {
            System.out.println("Inputfile construction failed");
        }
    }
}
