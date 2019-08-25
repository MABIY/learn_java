package annotations.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lh
 * Reflection-based annotation processor
 * {Args : annotations.database.Member}
 **/
public class TableCreator {
    public static void main(String[] args) throws ClassNotFoundException {
        args = new String[]{"annotations.database.Member"};
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
                }
                if (annes[0] instanceof SQLString) {
                    SQLString sString = (SQLString) annes[0];
                    // Use field name if name not specified
                    if (sString.name().length() < 1) {
                        columnName = declaredField.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")");
                    getConstraints(sString.constraints());
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
