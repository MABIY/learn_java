package typeinfo1;

public class Position {
    private String title;

    private Person person;

    public Position(String title, Person person) {
        this.title = title;
        this.person = person;
        if (person == null) {
            person = Person.NULL;
        }
    }

    public Position(String jobTitle) {
        title = jobTitle;
        person = Person.NULL;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Postion: " + title + " " + person;
    }

    public String getTitle() {
        return title;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
