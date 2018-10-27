import connection.DatabaseConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DatabaseConnectionTest {
    DatabaseConnection databaseConnection;
    Connection connection;

    @Before
    public void createNewDatabaseConnectionInstance() {
        databaseConnection = DatabaseConnection.getNewInstance();
        assertNotNull(databaseConnection);
        connection = databaseConnection.getConnection();
        assertNotNull(connection);
    }


    @Test
    public void queryTest() throws SQLException {
        assertEquals(1, 1);
        String query = "SELECT * FROM users WHERE name='RezaEskandari'";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()){
            assertEquals("RezaEskandari",resultSet.getString("name"));
            assertNotNull(resultSet);
        }
    }

    @After
    public void closeConnection(){
        try {
            connection.close();
            assertTrue(connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
