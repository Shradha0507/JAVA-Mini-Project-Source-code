import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class A15BookingConfirmationPage extends JFrame {
    private A3User user;
    private A4Flight flight;
    private BufferedImage backgroundImage;

    public A15BookingConfirmationPage(A3User user, A4Flight flight) {
        this.user = user;
        this.flight = flight;

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("C:/Users/aaral/Desktop/Javaprojects/Newproject2/src/images/f7.jpg")); // Update with your image path
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Booking Confirmation");
        setSize(480, 360); // Smaller size for the content
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Custom panel for the background image
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

        // Add labels for booking confirmation with dark gray background and white text
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1; // Allow components to grow vertically
        JPanel flightNumberPanel = new JPanel();
        flightNumberPanel.setBackground(Color.DARK_GRAY); // Set to dark gray
        JLabel flightNumberLabel = new JLabel("Booking Confirmed for Flight: " + flight.getFlightNumber(), SwingConstants.CENTER);
        flightNumberLabel.setForeground(Color.WHITE); // Set text color to white
        flightNumberPanel.add(flightNumberLabel);
        panel.add(flightNumberPanel, gbc);
        
        gbc.gridy = 1;
        JPanel originPanel = new JPanel();
        originPanel.setBackground(Color.DARK_GRAY); // Set to dark gray
        JLabel originLabel = new JLabel("Origin: " + flight.getOrigin(), SwingConstants.CENTER);
        originLabel.setForeground(Color.WHITE); // Set text color to white
        originPanel.add(originLabel);
        panel.add(originPanel, gbc);
        
        gbc.gridy = 2;
        JPanel destinationPanel = new JPanel();
        destinationPanel.setBackground(Color.DARK_GRAY); // Set to dark gray
        JLabel destinationLabel = new JLabel("Destination: " + flight.getDestination(), SwingConstants.CENTER);
        destinationLabel.setForeground(Color.WHITE); // Set text color to white
        destinationPanel.add(destinationLabel);
        panel.add(destinationPanel, gbc);

        // Back to User Profile Button
        JButton backButton = new JButton("Back to User Profile");
        backButton.addActionListener(e -> {
            dispose();
            new A16UserProfilePage(user).setVisible(true);
        });
        
        gbc.gridy = 3;
        gbc.weighty = 0; // Do not grow vertically
        panel.add(backButton, gbc);

        setContentPane(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            A3User user = new A3User(); // Dummy user for testing
            A4Flight flight = new A4Flight(); // Dummy flight for testing
            new A15BookingConfirmationPage(user, flight).setVisible(true);
        });
    }
}/* 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class A14PaymentPage extends JFrame {
    private A3User user;
    private A4Flight flight;
    private BufferedImage backgroundImage;

    public A14PaymentPage(A3User user, A4Flight flight) {
        this.user = user;
        this.flight = flight;

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("path/to/your/background_image.jpg")); // Update with your image path
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Payment Page");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Custom panel for the background image
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

        // Add flight payment information
        JLabel paymentInfoLabel = new JLabel("Payment for Flight: " + flight.getFlightNumber(), SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(paymentInfoLabel, gbc);

        // Pay Now Button
        JButton payButton = new JButton("Pay Now");
        payButton.addActionListener(new PayAction());
        gbc.gridy = 1;
        panel.add(payButton, gbc);

        setContentPane(panel);
    }

    private class PayAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Here you would typically integrate with a payment gateway
            JOptionPane.showMessageDialog(A14PaymentPage.this, "Payment successful! Please verify your email.");
            dispose();
            new A16EmailVerificationPage(user, flight).setVisible(true); // Navigate to Email Verification Page
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            A3User user = new A3User(); // Dummy user for testing
            A4Flight flight = new A4Flight(); // Dummy flight for testing
            new A14PaymentPage(user, flight).setVisible(true);
        });
    }
} 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class A14PaymentPage extends JFrame {
    private A3User user;
    private A4Flight flight;
    private BufferedImage backgroundImage;

    public A14PaymentPage(A3User user, A4Flight flight) {
        this.user = user;
        this.flight = flight;

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("path/to/your/background_image.jpg")); // Update with your image path
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Payment Page");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Custom panel for the background image
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

        // Add flight payment information
        JLabel paymentInfoLabel = new JLabel("Payment for Flight: " + flight.getFlightNumber(), SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(paymentInfoLabel, gbc);

        // Pay Now Button
        JButton payButton = new JButton("Pay Now");
        payButton.addActionListener(new PayAction());
        gbc.gridy = 1;
        panel.add(payButton, gbc);

        setContentPane(panel);
    }

    private class PayAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Simulate sending a verification email
            JOptionPane.showMessageDialog(A14PaymentPage.this, "Payment successful! Please verify your email.");
            dispose();
            new A16EmailVerificationPage(user, flight).setVisible(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            A3User user = new A3User(); // Dummy user for testing
            A4Flight flight = new A4Flight(); // Dummy flight for testing
            new A14PaymentPage(user, flight).setVisible(true);
        });
    }
}*/
