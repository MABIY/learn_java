package generics1;

import sun.security.timestamp.TSRequest;
import sun.security.timestamp.TSResponse;
import sun.security.timestamp.Timestamper;

import java.io.IOException;
import java.util.Date;

interface TimeStamped{
    long getStamp();
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;

    public TimeStampedImp() {
        this.timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {
    long getSerialNumbered();
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;
    @Override
    public long getSerialNumbered() {
        return serialNumber;
    }
}

interface Basic{
    public void set(String val);

    public String get();
}

class BasicImpl implements Basic {
    private String value;
    @Override
    public void set(String val) {
        value = val;
    }

    @Override
    public String get() {
        return value;
    }
}

class Mixin extends BasicImpl implements TimeStamped, SerialNumbered {
    private TimeStamped timeStamped = new TimeStampedImp();
    private SerialNumbered serialNumbered = new SerialNumberedImp();

    @Override
    public long getSerialNumbered() {
        return serialNumbered.getSerialNumbered();
    }

    @Override
    public long getStamp() {
        return timeStamped.getStamp();
    }
}

public class Mixins {
    public static void main(String[] args) {
        Mixin mixin1= new Mixin(),mixin2 = new Mixin();
        mixin1.set("test String 1");
        mixin2.set("test String 2");
        System.out.println(mixin1.get()+ " " + mixin1.getStamp() + " " + mixin1.getSerialNumbered());
        System.out.println(mixin2.get()+ " " + mixin2.getStamp() + " " + mixin2.getSerialNumbered());
    }
}
