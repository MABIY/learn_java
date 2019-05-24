package typeinfo;

import java.util.ArrayList;

/**
 * @author lh
 **/
public class Staff extends ArrayList<Position> {
    public void add(String title, Person person) {
        add(new Position(title, person));
    }

    public void add(String... titles) {
        for (String tilte : titles) {
            add(new Position(tilte));
        }
    }

    public Staff(String... titles) {
        add(titles);
    }

    public boolean positionAvailable(String title) {
        for (Position position : this) {
            if (position.getTitle().equals(title) &&
                    position.getPerson() == Person.NULL) {
                return true;
            }
        }
        return false;
    }

    public void fillPosition(String title, Person hire) {
        for (Position position : this) {
            if (position.getTitle().equals(title) &&
                    position.getPerson() == Person.NULL) {
                position.setPerson(hire);
                return;
            }
        }

        throw new RuntimeException(
                "Position " + title + " not available");
    }

    public static void main(String[] args) {
        Staff staff = new Staff("President", "CTO", "Marketing Manager", "Product Manager",
                "Project Lead", "Software Engineer", "software engineer", "software engineer", "Test Engineere");

        staff.fillPosition("President", new Person("Me", "Last", "The Top, Lonely At"));
        staff.fillPosition("Project Lead", new Person("Janet", "Planner", "The Brubs"));

        if (staff.positionAvailable("Software Engineer")) {
            staff.fillPosition("Software Engineer",new Person("Bob","Coder","Bright Light City"));
        }
        System.out.println(staff);
    }
}
