
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class A8BookingController {
    public boolean bookFlight(A5Booking booking) {
        try (Connection connection = A2DatabaseConnection.getConnection()) {
            String query = "INSERT INTO bookings (user_id, flight_id, booking_date) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, booking.getUserId());
            statement.setInt(2, booking.getFlightId());
            statement.setTimestamp(3, new java.sql.Timestamp(new Date().getTime()));
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
