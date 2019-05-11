package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * @author lh
 * Create two exception classes, each of which performs its own logging automatically
 * Demonstrate that these work.
 **/
class LoggingException1 extends Exception {
   private static Logger logger = Logger.getLogger("LoggingException1");

   public LoggingException1() {
      StringWriter trace = new StringWriter();
      printStackTrace(new PrintWriter(trace));
      logger.severe(trace.toString());
   }
}

class LoggingException23 extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException23");

   public LoggingException23() {
      StringWriter trace  =new StringWriter();
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
      try{
         throw new LoggingException23();
      } catch (LoggingException23 loggingException23) {
         System.out.println("Caught " +loggingException23);
      }
   }
}
