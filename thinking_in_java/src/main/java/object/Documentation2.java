package object;
// object.Documentation1.java
// TIJ4 Chapter Object, Exercise 13 - 2
/* Run Documentation1.java, Documentation2.java and Documentation3.java
 * through Javadoc. Verify the resulting documentation with your Web browser.
 */



// object/Docuemntation2.java

import java.util.Date;

/**
 * <pre>
 *     Uses
 *     System.out.println(new Date())
 * </pre>
 */
public class Documentation2 {
    Date d = new Date();

    void showDate() {
        System.out.println("Date = " + d);
    }
}
