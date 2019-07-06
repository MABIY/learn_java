package io;

import net.lh.util.BinaryFile;

import java.io.IOException;
import java.util.*;

/**
 * @author lh
 * Using BinaryFile and a Map<Byte,Integer>,create
 * aa program that counts the occurrence of all
 * the different bytes in a file
 **/
public class E19_BytesInfo {
    public static void main(String[] args) throws IOException {
        Map<Byte, Integer> bytesStat = new HashMap<>();
        for (Byte bt : BinaryFile.read("thinking_in_java/src/main/java/net/lh/util/E19_BytesInfo.java")) {
            Integer freq = bytesStat.get(bt);
            bytesStat.put(bt, freq == null ? 1 : freq + 1);
        }

        List<Byte> keys = new ArrayList<>(bytesStat.keySet());
        Collections.sort(keys);
        for (Byte key : keys) {
            System.out.println(key + " => " + bytesStat.get(key));
        }
    }
}
