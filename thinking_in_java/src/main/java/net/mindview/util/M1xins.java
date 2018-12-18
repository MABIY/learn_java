package net.mindview.util;

import java.util.Date;

/**
 * @author: liuHua
 * @create: 2018-12-18 16:25
 **/
interface TimeStamped{
	long getStamp();
}

class TimeStampedImp implements TimeStamped{
	private final long timeStamp;
	
	public TimeStampedImp() {
		timeStamp = new Date().getTime();
	}
	
	
	public long getStamp() {
		return timeStamp;
	}
}

interface SerialNumbered{
	long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered{
	private static long counter = 1;
	@Override
	public long getSerialNumber() {
		return 0;
	}
}
public class M1xins {
}
