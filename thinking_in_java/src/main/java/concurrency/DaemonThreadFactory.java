package concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * Created by LiuHua on 18-3-26.
 */
public class DaemonThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
