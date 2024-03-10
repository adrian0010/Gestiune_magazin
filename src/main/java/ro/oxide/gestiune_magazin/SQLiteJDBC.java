package ro.oxide.gestiune_magazin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the database (if the database file does not exist, it will be created)
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");

            // Create a table
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();

            System.out.println("Table created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
