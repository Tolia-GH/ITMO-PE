package Tools;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres","postgres","123456")){
            System.out.print(connection);
        }


    }
}
