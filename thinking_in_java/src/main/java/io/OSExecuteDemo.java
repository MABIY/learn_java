package io;

import net.lh.util.OSExecute;

/**
 * @author lh
 * Demonstrates standard I/O redirection.
 **/
public class OSExecuteDemo {
    public static void main(String[] args) {
        OSExecute.command("javap");
    }
}
