package jdbc.task01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

@SuppressWarnings("WeakerAccess")
public class DbOperations {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:test");
        Statement statement = connection.createStatement();
        Files.lines(Paths.get("jdbc/src/main/resources/source.sql")).forEachOrdered(
                s -> {
                    try {
                        statement.addBatch(s);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
        statement.executeBatch();
        connection.commit();

        f1(connection);
        f2(connection);
        f3(connection);
        f4(connection);
        f5(connection);
    }

    //get data by sql query
    public static void f1(Connection connection) throws SQLException {
        ResultSet res = connection.prepareStatement("SELECT key, value FROM table1 WHERE (key < 5)"
        ).executeQuery();

        System.out.println("SELECT key, value FROM table1 WHERE (key < 5)");
        while (res.next()) {
            System.out.println(res.getInt("key") + " " + res.getInt("value"));
        }
        System.out.println();
    }

    public static void f2(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.addBatch("UPDATE table1 SET  value = 999999 WHERE key=1");
        statement.addBatch("UPDATE table1 SET  value = 900000 WHERE key=2");
        statement.executeBatch();
        connection.commit();

        System.out.println("UPDATE table1 SET  value = 999999 WHERE key=1");
        System.out.println("UPDATE table1 SET  value = 900000 WHERE key=2");
        f1(connection);
    }

    public static void f3(Connection connection)throws SQLException{
        ResultSet res = connection.prepareStatement("SELECT key, value FROM table1 WHERE (key = 121)").executeQuery();

        System.out.println("SELECT key, value FROM table1 WHERE (key = 121)");
        while (res.next()) {
            System.out.println(res.getInt("key") + " " + res.getInt("value"));
        }
        System.out.println();
    }

    public static void f4(Connection connection)throws SQLException{
        Statement statement = connection.createStatement();
        statement.addBatch("INSERT INTO table1 VALUES (121, 999999)");
        statement.executeBatch();
        connection.commit();

        System.out.println("INSERT INTO table1 VALUES (121, 999999)");
        f3(connection);
    }

    private static void f5_0(Connection connection){
        try {
            System.out.println("SELECT * FROM table2");
            connection.prepareStatement("SELECT * FROM table2").executeQuery();
        } catch (SQLException e) {
            System.out.println("sql exception");
        }
    }

    public static void f5(Connection connection)throws SQLException{
        f5_0(connection);

        Statement statement = connection.createStatement();
        statement.addBatch("DROP TABLE table2");
        System.out.println("DROP TABLE table2");
        statement.executeBatch();

        f5_0(connection);
    }


}
