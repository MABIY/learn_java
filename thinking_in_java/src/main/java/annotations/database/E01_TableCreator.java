package annotations.database;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 * {Args:annotations.Member}
 * ******************************
 * Implement more SQL types in the database example
 * ******************************
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLBoolean{
    String name() default "";
    Constraints constraints() default @Constraints;
}
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLCharacter{
    int value() default 0;
    String name() default "";
    Constraints constraints() default @Constraints;
}
@DBTable(name = "MEMBER")
class Member1{
    @SQLString(30)
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLCharacter(value = 15,constraints = @Constraints(primaryKey =true))
   String handle;
    static int memberCount;
    @SQLBoolean Boolean isVIP;

    public Boolean getVIP() {
        return isVIP;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    @Override
    public String toString() {
        return handle;
    }
}
public class E01_TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        args = new String[]{"annotations.database.Member1"};
        if (args.length < 1) {
            System.out.println("arguments : annotated classes");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            // if the name is empty, use the Class name:
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field declaredField : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annes = declaredField.getDeclaredAnnotations();
                if (annes.length < 1) {
                    continue; // NOt a db table column
                }
                if (annes[0] instanceof SQLInteger) {
                    SQLInteger sINt = (SQLInteger) annes[0];
                    // Use field name if name not specified
                    if (sINt.name().length() < 1) {
                        columnName = declaredField.getName().toUpperCase();
                    } else {
                        columnName = sINt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstraints(sINt.constraints()));
                } else if (annes[0] instanceof SQLString) {
                    SQLString sString = (SQLString) annes[0];
                    // Use field name if name not specified
                    if (sString.name().length() < 1) {
                        columnName = declaredField.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")");
                    getConstraints(sString.constraints());
                } else if (annes[0] instanceof SQLBoolean) {
                    SQLBoolean sBol = (SQLBoolean) annes[0];
                    // Use field name if name not specified
                    if (sBol.name().length() < 1) {
                        columnName = declaredField.getName().toUpperCase();
                    } else {
                        columnName = sBol.name();
                    }
                    columnDefs.add(columnName + " BOOLEAN" + getConstraints(sBol.constraints()));
                } else if (annes[0] instanceof SQLCharacter) {
                    SQLCharacter sChar = (SQLCharacter) annes[0];
                    // Use field name if name not specified.
                    if (sChar.name().length() < 1) {
                        columnName = declaredField.getName().toUpperCase();
                    } else {
                        columnName = sChar.name();
                    }
                    columnDefs.add(columnName + " CHARCTER(" + sChar.value() + ")");
                    getConstraints(sChar.constraints());
                }

                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
                for (String columnDef : columnDefs) {
                    createCommand.append("\n  " + columnDef + ",");
                }
                //Remove trailing comma
                String tableCreate = createCommand.substring(
                        0, createCommand.length() - 1) + ")";
                System.out.println(
                        "Table Creation SQL for " + className + " is :\n" + tableCreate);
            }

        }
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (con.unique()) {
            constraints += " UNIQUE";
        }
        return constraints;
    }
}
