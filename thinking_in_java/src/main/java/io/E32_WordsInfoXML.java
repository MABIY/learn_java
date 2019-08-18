package io;

import net.mindview.util.TextFile;
import nu.xom.*;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lh
 * {Requires: un.xom.Node; You must install}
 * The XOM libray from http://www.xom.nu
 * {RunByHand}
 * ********************
 * Using a Map<String,Integer> and the
 * net.mindview.util.TextFile utility.write a
 * program that counts the occurrence of words in
 * a file (use "\\W+" as the  second argument to the
 * TextFile constructor). Store the results as an
 * XML file
 **/
public class E32_WordsInfoXML {
    // Produce an XML Element from this Map.Entry object:
    static Element getXML(Map.Entry<String, Integer> me) {
        Element record = new Element("record");
        Element word = new Element("word");
        word.appendChild(me.getKey());
        Element freq = new Element("frequency");
        freq.appendChild(me.getValue().toString());
        record.appendChild(word);
        record.appendChild(freq);
        return record;
    }

    public static void main(String[] args) throws IOException {
        Map<String, Integer> wordStat = new HashMap<>();
        for (String word : new TextFile("thinking_in_java/src/main/java/io/E32_WordsInfoXML.java", "\\W+")) {
            Integer freq = wordStat.get(word);
            wordStat.put(word, freq == null ? 1 : freq + 1);
        }
        Element root = new Element("words");
        for (Map.Entry<String, Integer> me : wordStat.entrySet()) {
            root.appendChild(getXML(me));
        }
        Document doc = new Document(root);
        Person.format(System.out, doc);
        Person.format(new BufferedOutputStream(new FileOutputStream(
                "WordsInf.xml")), doc
        );


    }
}
