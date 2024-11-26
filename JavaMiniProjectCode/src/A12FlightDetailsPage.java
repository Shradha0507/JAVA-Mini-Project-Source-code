
/*import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class A12FlightDetailsPage extends JFrame {
    private JTable flightTable;
    private DefaultTableModel tableModel;
    private A3User user;
    private List<A4Flight> flights;

    public A12FlightDetailsPage(A3User user, List<A4Flight> flights) {
        this.user = user;
        this.flights = flights;

        setTitle("Flight Details");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new String[]{"Flight Number", "Origin", "Destination", "Departure", "Arrival", "Price", "Available Seats"}, 0);
        flightTable = new JTable(tableModel);
        add(new JScrollPane(flightTable), BorderLayout.CENTER);

        for (A4Flight flight : flights) {
            tableModel.addRow(new Object[]{
                    flight.getFlightNumber(),
                    flight.getOrigin(),
                    flight.getDestination(),
                    flight.getDepartureDate(),
                    flight.getArrivalDate(),
                    flight.getPrice(),
                    flight.getAvailableSeats()
            });
        }

        JButton bookButton = new JButton("Book Flight");
        bookButton.addActionListener(new BookAction());
        add(bookButton, BorderLayout.SOUTH);
    }

    private class BookAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = flightTable.getSelectedRow();
            if (selectedRow != -1) {
                A4Flight selectedFlight = flights.get(selectedRow);
                dispose();
                new A13BookingPage(user, selectedFlight).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(A12FlightDetailsPage.this, "Please select a flight!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}*/
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class A12FlightDetailsPage extends JFrame {
    private JTable flightTable;
    private DefaultTableModel tableModel;
    private A3User user;
    private List<A4Flight> flights;
    private BufferedImage backgroundImage;

    public A12FlightDetailsPage(A3User user, List<A4Flight> flights) {
        this.user = user;
        this.flights = flights;

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("path/to/your/background_image.jpg")); // Update with your image path
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Flight Details");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a custom panel for the background image
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
                }
            }
        };

        panel.setLayout(new BorderLayout());
        panel.setOpaque(false); // Allow transparency

        // Create table model and table
        tableModel = new DefaultTableModel(new String[]{"Flight Number", "Origin", "Destination", "Departure", "Arrival", "Price", "Available Seats"}, 0);
        flightTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make cells non-editable
            }
        };
        
        // Set table properties for transparency
        flightTable.setOpaque(false);
        flightTable.setBackground(new Color(0, 0, 0, 0)); // Fully transparent background
        flightTable.setSelectionBackground(new Color(135, 206, 250, 150)); // Light blue selection color with some transparency
        flightTable.setSelectionForeground(Color.BLACK); // Black text on selection

        // Add flight data to the table
        for (A4Flight flight : flights) {
            tableModel.addRow(new Object[]{
                    flight.getFlightNumber(),
                    flight.getOrigin(),
                    flight.getDestination(),
                    flight.getDepartureDate(),
                    flight.getArrivalDate(),
                    flight.getPrice(),
                    flight.getAvailableSeats()
            });
        }

        // Add components to the panel
        panel.add(new JScrollPane(flightTable), BorderLayout.CENTER);
        JScrollPane scrollPane = new JScrollPane(flightTable);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false); // Make the viewport transparent
        panel.add(scrollPane, BorderLayout.CENTER);

        // Create a button panel for booking
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton bookButton = new JButton("Book Flight");
        bookButton.addActionListener(new BookAction());
        buttonPanel.add(bookButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the panel to the frame
        setContentPane(panel);
    }

    private class BookAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = flightTable.getSelectedRow();
            if (selectedRow != -1) {
                A4Flight selectedFlight = flights.get(selectedRow);
                dispose();
                new A13BookingPage(user, selectedFlight).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(A12FlightDetailsPage.this, "Please select a flight!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new A12FlightDetailsPage(new A3User(), List.of()).setVisible(true));
    }
}