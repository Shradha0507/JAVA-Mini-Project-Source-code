
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A2DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/flight_booking?useSSL=false";
    private static final String USER = "root"; // Replace with your MySQL user
    private static final String PASSWORD = "Shradha123#"; // Replace with your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
