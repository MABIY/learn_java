package xml;

import nu.xom.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author lh
 * {Requires: nu.xml.Node: You must intall}
 * the XOM libray from http://www.xom.nu
 * {RunFirst: Person}
 **/
public class People extends ArrayList<Person> {
    public People(String fileName) throws ParsingException, IOException {
        Document doc = new Builder().build(fileName);
        Elements elements = doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++) {
            add(new Person(elements.get(i)));
        }
    }

    public static void main(String[] args) throws ParsingException, IOException {
        People p = new People("file:///home/lh/project/learn_java/People.xml");
        System.out.println(p);
    }
}
