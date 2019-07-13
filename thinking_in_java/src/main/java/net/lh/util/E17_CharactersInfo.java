package net.lh.util;

import java.util.*;

/**
 * @author lh
 * Using TextFile and a Map<Character,Integer>,
 * create a program that counts the occurrence of
 * all the different characters in a file. (so if
 * there are 12 occurrences of the letter 'a' in
 * the file, the Integer associated with the Character
 * containing 'a' in the Map contains '12'
 **/
public class E17_CharactersInfo {
    public static void main(String[] args) {
        Map<Character, Integer> charsStat = new HashMap<>();
        for (String word : new TextFile("thinking_in_java/src/main/java/net/lh/util/E17_CharactersInfo.java", "\\W+")) {
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                Integer freq = charsStat.get(ch);
                charsStat.put(ch, freq == null ? 1 : freq + 1);
            }
        }
        List<Character> keys = Arrays.asList(
                charsStat.keySet().toArray(new Character[0])
        );
        Collections.sort(keys);
        for (Character key : keys) {
            System.out.println(key + " => " + charsStat.get(key));
        }
    }
}
