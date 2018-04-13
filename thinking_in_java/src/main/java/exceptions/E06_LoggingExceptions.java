package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by LiuHua on 18-4-10.
 */

class LoggingException1 extends Exception {
   private static Logger logger = Logger.getLogger(LoggingException1.class.getName());

   public LoggingException1() {
      StringWriter trace = new StringWriter();
      printStackTrace(new PrintWriter(trace));
      logger.severe(trace.toString());
   }
}

class LoggingException3 extends Exception {
    private static Logger logger = Logger.getLogger(LoggingException3.class.getName());

    public LoggingException3() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}


public class E06_LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException1();
        } catch (LoggingException1 loggingException1) {
            System.out.println("Caught " + loggingException1);
        }
        try {
            throw new LoggingException3();
        } catch (LoggingException3 loggingException3) {
            System.out.println("Caught " + loggingException3);
        }
    }
}
