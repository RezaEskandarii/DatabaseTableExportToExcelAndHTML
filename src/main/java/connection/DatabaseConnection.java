package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private DatabaseConnection() {
    }

    private static DatabaseConnection connection = null;

    public Connection getConnection() {
        try {
            Class.forName(Config.DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static DatabaseConnection getNewInstance() {
        synchronized (DatabaseConnection.class) {
            if (connection == null) {
                connection = new DatabaseConnection();
            }
        }
        return connection;
    }
}
