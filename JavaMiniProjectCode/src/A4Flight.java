
import java.util.Date;

public class A4Flight {
    private int id;
    private String flightNumber;
    private String origin;
    private String destination;
    private Date departureDate;
    private Date arrivalDate;
    private double price;
    private int availableSeats;

    // Getters and Setters
    // ...
    public int getId() {
        return id;
    }
    public String getFlightNumber() {
        return flightNumber;
    }
    public String getOrigin() {
        return origin;
    }
    public String getDestination() {
        return destination;
    }
    public Date getDepartureDate() {
        return departureDate;
    }
    public Date getArrivalDate() {
        return arrivalDate;
    }
    public double getPrice() {
        return price;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
