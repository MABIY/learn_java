package io;


import nu.xom.*;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lh
 * {Requires: nu.xml.Node; you must install}
 * the XOM libray form http:www.xml.nu
 * <p>
 * Add appropriate address information to Person.java
 **/
class Person {
    public static final String FIRST = "first";
    public static final String LAST = "last";
    public static final String ADDRSS = "addrss";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ZIP_CODE = "zipCode";
    private String first, last, address, city, state;
    private int zipCode;

    public Person(String first, String last, String address, String city, String state, int zipCode) {
        this.first = first;
        this.last = last;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Constructor to restore a Person from an XML Element
    public Person(Element person) {
        first = person.getFirstChildElement(FIRST).getValue();
        last = person.getFirstChildElement(LAST).getValue();
        address = person.getFirstChildElement(ADDRSS).getValue();
        city = person.getFirstChildElement(CITY).getValue();
        state = person.getFirstChildElement(STATE).getValue();
        zipCode = Integer.valueOf(person.getFirstChildElement(ZIP_CODE).getValue());
    }

    // Make it human-readable:
    public static void format(OutputStream os, Document doc) throws IOException {
        Serializer serializer = new Serializer(os, "UTF-8");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    // Produce an  XML Element from this person object:
    public Element getXML() {
        Element person = new Element("person");
        Element firstName = new Element(FIRST);
        firstName.appendChild(first);
        Element lastName = new Element(LAST);
        lastName.appendChild(last);
        Element addr = new Element(ADDRSS);
        addr.appendChild(address);
        Element cty = new Element(CITY);
        cty.appendChild(city);
        Element st = new Element(STATE);
        st.appendChild(state);
        Element zc = new Element(ZIP_CODE);
        zc.appendChild(Integer.toString(zipCode));
        person.appendChild(firstName);
        person.appendChild(lastName);
        person.appendChild(addr);
        person.appendChild(cty);
        person.appendChild(st);
        person.appendChild(zc);
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}

class People extends ArrayList<Person> {
    public People(String fileName) throws ParsingException, IOException {
        Document doc = new Builder().build(fileName);
        Elements elements = doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++) {
            add(new Person(elements.get(i)));
        }
    }
}

public class E31_PeopleWithAddresses {
    public static void main(String[] args) throws IOException, ParsingException {
        List<Person> people = Arrays.asList(
                new Person("Dr. Bunsen", "Honeydew", "Street 1", "New York", "NY", 10001),
                new Person("Gonzo", "The Great", "Street 2", "New York", "NY", 20002),
                new Person("Phillip J.", "Fry", "Stret 3", "New York", "NY", 30003)


                );
        System.out.println(people);
        Element root = new Element("people");
        for (Person person : people) {
            root.appendChild(person.getXML());
        }
        Document doc = new Document(root);
        Person.format(System.out,doc);
        Person.format(new BufferedOutputStream(
                new FileOutputStream("People.xml")
        ), doc);
        People p = new People("file:///home/lh/project/learn_java/People.xml");
        System.out.println(p);

    }
}
