
/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A14PaymentPage extends JFrame {
    private A3User user;
    private A4Flight flight;

    public A14PaymentPage(A3User user, A4Flight flight) {
        this.user = user;
        this.flight = flight;

        setTitle("Payment Page");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));

        add(new JLabel("Payment for Flight: " + flight.getFlightNumber(), SwingConstants.CENTER));

        JButton payButton = new JButton("Pay Now");
        payButton.addActionListener(new PayAction());
        add(payButton);
    }

    private class PayAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Here you would typically integrate with a payment gateway
            JOptionPane.showMessageDialog(A14PaymentPage.this, "Payment successful! Booking confirmed!");
            dispose();
            new A15BookingConfirmationPage(user, flight).setVisible(true);
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

public class A14PaymentPage extends JFrame {
    private A3User user;
    private A4Flight flight;
    private BufferedImage backgroundImage;

    public A14PaymentPage(A3User user, A4Flight flight) {
        this.user = user;
        this.flight = flight;

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("C:/Users/aaral/Desktop/Javaprojects/Newproject2/src/images/f1.jpg")); // Update with your image path
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Payment Page");
        setSize(500, 333);
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
        paymentInfoLabel.setForeground(Color.WHITE);
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
            JOptionPane.showMessageDialog(A14PaymentPage.this, "Payment successful! Booking confirmed!");
            dispose();
            new A15BookingConfirmationPage(user, flight).setVisible(true);
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
