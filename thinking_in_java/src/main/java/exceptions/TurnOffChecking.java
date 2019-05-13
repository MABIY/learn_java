package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

import static net.lh.util.Print.print;

/**
 * @author lh
 * "Turning off" checked excpeions
 **/
class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new FileNotFoundException();
                case 1:
                    throw new IOException();
                case 2:
                    throw new RuntimeException("Where am !?");
                    default:
                        return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class SomeOtherException extends Exception{}

public class TurnOffChecking {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        // YOu can call throwRuntimeException() without a try
        // block,and let RuntimeExceptions leave the method:
        wce.throwRuntimeException(3);
        //or you can choose to catch exceptions:
        for (int i = 0; i < 4; i++) {
            try {
                if (i < 3) {
                    wce.throwRuntimeException(i);
                } else
                    throw new SomeOtherException();
            } catch (SomeOtherException e) {
                print("SomeotherException: " + e);
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (FileNotFoundException e) {
                    print("FileNotFoundException: " + e);
                } catch (IOException e) {
                    print("IOException: " + e);
                } catch (Throwable e) {
                    print("Throwable: " +e);
                }
            }
        }

    }
}
