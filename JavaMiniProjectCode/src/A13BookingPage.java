
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A13BookingPage extends JFrame {
    private A3User user;
    private A4Flight flight;
    private JTextField passengerNameField;
    private JTextField passengerEmailField;

    public A13BookingPage(A3User user, A4Flight flight) {
        this.user = user;
        this.flight = flight;

        setTitle("Booking Page");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Passenger Name:"));
        passengerNameField = new JTextField();
        add(passengerNameField);

        add(new JLabel("Passenger Email:"));
        passengerEmailField = new JTextField();
        add(passengerEmailField);

        JButton confirmButton = new JButton("Confirm Booking");
        confirmButton.addActionListener(new ConfirmBookingAction());
        add(confirmButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            dispose();
            new A11FlightSearchPage(user).setVisible(true);
        });
        add(cancelButton);
    }

    private class ConfirmBookingAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            A5Booking booking = new A5Booking();
            booking.setUserId(user.getId());
            booking.setFlightId(flight.getId());

            A8BookingController bookingController = new A8BookingController();
            if (bookingController.bookFlight(booking)) {
                JOptionPane.showMessageDialog(A13BookingPage.this, "Booking successful!");
                dispose();
                new A14PaymentPage(user, flight).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(A13BookingPage.this, "Booking failed!", "Error", JOptionPane.ERROR_MESSAGE);
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

public class A13BookingPage extends JFrame {
    private A3User user;
    private A4Flight flight;
    private JTextField passengerNameField;
    private JTextField passengerEmailField; // Added email field
    private BufferedImage backgroundImage;

    public A13BookingPage(A3User user, A4Flight flight) {
        this.user = user;
        this.flight = flight;

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("C:/Users/aaral/Desktop/Javaprojects/Newproject2/src/images/f5.jpg")); // Update with your image path
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Booking Page");
        setSize(700, 500);
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
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false); // Allow transparency

        // Create layout constraints for centering components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        gbc.anchor = GridBagConstraints.CENTER; // Center components

        // Passenger Name Field
    gbc.gridx = 0;
    gbc.gridy = 0;

    // Create a panel for the label
    JPanel namePanel = new JPanel();
    namePanel.setBackground(Color.LIGHT_GRAY); // Set background color for label
    namePanel.add(new JLabel("Passenger Name:"));
    panel.add(namePanel, gbc);

    gbc.gridx = 1;
    passengerNameField = new JTextField(15);
    panel.add(passengerNameField, gbc);

    // Passenger Email Field
    gbc.gridx = 0;
    gbc.gridy = 1;

    // Create a panel for the label
    JPanel emailPanel = new JPanel();
    emailPanel.setBackground(Color.LIGHT_GRAY); // Set background color for label
    emailPanel.add(new JLabel("Passenger Email:"));
    panel.add(emailPanel, gbc);

    gbc.gridx = 1;
    passengerEmailField = new JTextField(15);
    panel.add(passengerEmailField, gbc);
        

        // Confirm Booking Button
        gbc.gridx = 0;
        gbc.gridy = 2;
        JButton confirmButton = new JButton("Confirm Booking");
        confirmButton.addActionListener(new ConfirmBookingAction());
        panel.add(confirmButton, gbc);

        // Cancel Button
        gbc.gridx = 1;
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            dispose();
            new A11FlightSearchPage(user).setVisible(true);
        });
        panel.add(cancelButton, gbc);

        setContentPane(panel);
    }

    private class ConfirmBookingAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = passengerEmailField.getText(); // Get email from the text field
            String name = passengerNameField.getText(); // Get name from the text field
            
            if (email.isEmpty() || name.isEmpty()) {
                JOptionPane.showMessageDialog(A13BookingPage.this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Proceed with booking
            A5Booking booking = new A5Booking();
            booking.setUserId(user.getId());
            booking.setFlightId(flight.getId());

            A8BookingController bookingController = new A8BookingController();
            if (bookingController.bookFlight(booking)) {
                JOptionPane.showMessageDialog(A13BookingPage.this, "Booking successful!");
                dispose();
                new A14PaymentPage(user, flight).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(A13BookingPage.this, "Booking failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            A3User user = new A3User(); // Dummy user for testing
            user.setEmail("test_user@example.com"); // Set a dummy email for testing
            A4Flight flight = new A4Flight(); // Dummy flight for testing
            new A13BookingPage(user, flight).setVisible(true);
        });
    }
}