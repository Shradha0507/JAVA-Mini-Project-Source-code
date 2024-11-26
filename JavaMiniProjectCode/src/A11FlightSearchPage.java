
/*import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class A11FlightSearchPage extends JFrame {
    private JTextField originField;
    private JTextField destinationField;
    private JSpinner dateSpinner;
    private A3User user;
    private A7FlightController flightController;

    public A11FlightSearchPage(A3User user) {
        this.user = user;
        flightController = new A7FlightController();
        setTitle("Flight Search Page");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Origin:"));
        originField = new JTextField();
        add(originField);

        add(new JLabel("Destination:"));
        destinationField = new JTextField();
        add(destinationField);

        add(new JLabel("Departure Date:"));
        dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setValue(new Date()); // Set current date as default
        add(dateSpinner);

        JButton searchButton = new JButton("Search Flights");
        searchButton.addActionListener(new SearchAction());
        add(searchButton);

        JButton backButton = new JButton("Back to User Profile");
        backButton.addActionListener(e -> {
            dispose();
            new A16UserProfilePage(user).setVisible(true);
        });
        add(backButton);
    }

    private class SearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String origin = originField.getText();
            String destination = destinationField.getText();
            Date departureDate = (Date) dateSpinner.getValue();

            if (origin.isEmpty() || destination.isEmpty() || departureDate == null) {
                JOptionPane.showMessageDialog(A11FlightSearchPage.this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<A4Flight> flights = flightController.searchFlights(origin, destination, departureDate);
            if (flights.isEmpty()) {
                JOptionPane.showMessageDialog(A11FlightSearchPage.this, "No flights found!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dispose();
                new A12FlightDetailsPage(user, flights).setVisible(true);
            }
        }
    }
}*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class A11FlightSearchPage extends JFrame {
    private JTextField originField;
    private JTextField destinationField;
    private JSpinner dateSpinner;
    private A3User user;
    private A7FlightController flightController;
    private BufferedImage backgroundImage;

    public A11FlightSearchPage(A3User user) {
        this.user = user;
        flightController = new A7FlightController();
        setTitle("Flight Search Page");
        setSize(728, 455);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("C:/Users/aaral/Desktop/Javaprojects/Newproject2/bin/images/f2.jpg")); // Update with your image path
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false); // Allow transparency

        // Create layout constraints for centering components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        gbc.anchor = GridBagConstraints.CENTER; // Center components

        // Add components to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Create a panel for the Origin label
        JPanel originPanel = new JPanel();
        originPanel.setBackground(Color.LIGHT_GRAY); // Set background color for label
        originPanel.add(new JLabel("Origin:"));
        panel.add(originPanel, gbc);

        gbc.gridx = 1;
        originField = new JTextField(15);
        panel.add(originField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        // Create a panel for the Destination label
        JPanel destinationPanel = new JPanel();
        destinationPanel.setBackground(Color.LIGHT_GRAY); // Set background color for label
        destinationPanel.add(new JLabel("Destination:"));
        panel.add(destinationPanel, gbc);

        gbc.gridx = 1;
        destinationField = new JTextField(15);
        panel.add(destinationField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        // Create a panel for the Departure Date label
        JPanel departureDatePanel = new JPanel();
        departureDatePanel.setBackground(Color.LIGHT_GRAY); // Set background color for label
        departureDatePanel.add(new JLabel("Departure Date:"));
        panel.add(departureDatePanel, gbc);

        gbc.gridx = 1;
        dateSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setValue(new Date()); // Set current date as default
        panel.add(dateSpinner, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JButton searchButton = new JButton("Search Flights");
        searchButton.addActionListener(new SearchAction());
        panel.add(searchButton, gbc);

        gbc.gridx = 1;
        JButton backButton = new JButton("Back to User Profile");
        backButton.addActionListener(e -> {
            dispose();
            new A16UserProfilePage(user).setVisible(true);
        });
        panel.add(backButton, gbc);

        // Add the panel to the frame
        setContentPane(panel);
    }

    private class SearchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String origin = originField.getText().trim();
            String destination = destinationField.getText().trim();
            Date departureDate = (Date) dateSpinner.getValue();

            if (origin.isEmpty() || destination.isEmpty() || departureDate == null) {
                JOptionPane.showMessageDialog(A11FlightSearchPage.this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<A4Flight> flights = flightController.searchFlights(origin, destination, departureDate);
            if (flights.isEmpty()) {
                JOptionPane.showMessageDialog(A11FlightSearchPage.this, "No flights found!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                dispose();
                new A12FlightDetailsPage(user, flights).setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new A11FlightSearchPage(new A3User()).setVisible(true));
    }
}