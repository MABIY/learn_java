package access;

/**
 * @author lh
 * Following the form of the example Lunch.java,create a class called
 * ConnectionManager that manages a fiexed array of Connection objects.The client
 * programmer must not be able to explicitly create Connection objects, but can
 * only get them via a static method in ConnectionManager.When ConnectionManager
 * run out of objects,it returns a null reference. Test the classes in main()
 **/

class Connection {
    private static int count = 0;
    private int i = 0;

    private Connection() {
        System.out.println("Connection()");
    }

    //Allow create via static method:
    static Connection makeConnection() {
        count++;
        return new Connection();
    }

    public static int howMany() {
        return count;
    }

    @Override
    public String toString() {
        return ("Connection " + count);
    }
}

public class ConnectionManager {
    static int howMayLeft = 3;
    static Connection[] ca = new Connection[3];
    {
        for (Connection x : ca) {
            x = Connection.makeConnection();
        }
    }

    public static Connection getConnection() {
        if (howMayLeft > 0) {
            return ca[--howMayLeft];
        } else {
            System.out.println("No more connections");
            return null;
        }
    }

    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager();
        System.out.println(howMayLeft);
        getConnection();
        System.out.println(howMayLeft);
        getConnection();
        System.out.println(howMayLeft);
        getConnection();
        System.out.println(getConnection());
        System.out.println(howMayLeft);
    }
}
