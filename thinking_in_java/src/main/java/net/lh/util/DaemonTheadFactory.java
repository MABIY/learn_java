package net.lh.util;

import java.util.concurrent.ThreadFactory;

/**
 * @author lh
 */
public class DaemonTheadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
