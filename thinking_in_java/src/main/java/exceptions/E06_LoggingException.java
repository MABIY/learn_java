package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LoggingException1 extends Exception {
    private static Logger logger = Logger.getLogger(LoggingException1.class.getName());

    public LoggingException1() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

class LoggingException6_2 extends Exception {
    private static Logger logger = Logger.getLogger(LoggingException6_2.class.getName());

    public LoggingException6_2() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class E06_LoggingException {
    public static void main(String[] args) {
        try {
            throw new LoggingException1();
        } catch (LoggingException1 loggingException1) {
            System.out.println("Caught " + loggingException1);
        }

        try {
            throw new LoggingException6_2();
        } catch (LoggingException6_2 loggingException6_2) {
            System.out.println("Caught " +loggingException6_2);
        }
    }
}
