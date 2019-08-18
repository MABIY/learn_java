package xml;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author lh
 * Use the XOM library to write and read xml
 **/
public class Person {
    public static final String LAST = "last";
    public static final String FIRST = "first";
    private String first, last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Person(Element person) {
        first = person.getFirstChildElement(FIRST).getValue();
        last = person.getFirstChildElement(LAST).getValue();

    }

    // Constructor to restore a Person from an XML Element:

    public static void format(OutputStream os, Document doc) throws IOException {
        Serializer serializer = new Serializer(os, "UTF-8");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws IOException {
        List<Person> people = Arrays.asList(
                new Person("Dr. Bunsen", "Honeydew"),
                new Person("Gonzo", "The Great"),
                new Person("Phillip J.", "Fry")
        );
        System.out.println(people);
        Element root = new Element("people");
        for (Person person : people) {
            root.appendChild(person.getXml());
        }
        Document doc = new Document(root);
        format(System.out, doc);
        format(new BufferedOutputStream(
                new FileOutputStream("People.xml")), doc);

    }

    // Produce an Xml Element from this person object:
    public Element getXml() {
        Element person = new Element("person");
        Element firstName = new Element(FIRST);
        firstName.appendChild(first);
        Element lastName = new Element(LAST);
        lastName.appendChild(last);
        person.appendChild(firstName);
        person.appendChild(lastName);
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }
}
