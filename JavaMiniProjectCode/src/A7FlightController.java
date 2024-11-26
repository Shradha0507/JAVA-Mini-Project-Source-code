
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class A7FlightController {
    public List<A4Flight> searchFlights(String origin, String destination, java.util.Date departureDate) {
        List<A4Flight> flights = new ArrayList<>();
        try (Connection connection = A2DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM flights WHERE origin = ? AND destination = ? AND DATE(departure_date) = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, origin);
            statement.setString(2, destination);
            statement.setDate(3, new java.sql.Date(departureDate.getTime()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                A4Flight flight = new A4Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setFlightNumber(resultSet.getString("flight_number"));
                flight.setOrigin(resultSet.getString("origin"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setDepartureDate(resultSet.getTimestamp("departure_date"));
                flight.setArrivalDate(resultSet.getTimestamp("arrival_date"));
                flight.setPrice(resultSet.getDouble("price"));
                flight.setAvailableSeats(resultSet.getInt("available_seats"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }
}
