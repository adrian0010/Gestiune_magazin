package ro.oxide.gestiune_magazin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC {
    public static void main(String[] args) {
        createDB();
//        Connection connection = null;
//        try {
//            // Load the SQLite JDBC driver
//            Class.forName("org.sqlite.JDBC");
//
//            // Connect to the database (if the database file does not exist, it will be created)
//            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
//
//            // Create a table
//            Statement statement = connection.createStatement();
//            String sql = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT NOT NULL)";
//            statement.executeUpdate(sql);
//            statement.close();
//
//            System.out.println("Table created successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (connection != null)
//                    connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void createDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:inventory.db");

            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Products\n" +
                    "(\n" +
                    "    id              integer\n" +
                    "        primary key autoincrement,\n" +
                    "    name            VARCHAR(100) not null,\n" +
                    "    description     TEXT,\n" +
                    "    category        VARCHAR(50)  not null,\n" +
                    "    quantity        INT          not null,\n" +
                    "    expiration_date DATE,\n" +
                    "    buy_price       DECIMAL(10, 2),\n" +
                    "    buy_date        DATE,\n" +
                    "    price           DECIMAL(10, 2) not null,\n" +
                    "    manufacturer    VARCHAR(100),\n" +
                    "    weight          DECIMAL(10, 2),\n" +
                    "    size            VARCHAR(50),\n" +
                    "    color           VARCHAR(50),\n" +
                    "    rating          DECIMAL(3, 2),\n" +
                    "    location        VARCHAR(100)\n" +
                    ");\n";
            statement.executeUpdate(sql);
            statement.close();
            System.out.println("a mers");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}