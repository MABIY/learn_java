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
    private static Logger logger = Logger.getLogger("LoggingException2");

    public LoggingException3() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));

    }
}


public class E06_LoggingExceptions {
}
