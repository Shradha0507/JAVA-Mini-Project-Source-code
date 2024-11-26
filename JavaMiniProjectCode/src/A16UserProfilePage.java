
/*import javax.swing.*;
import java.awt.*;

public class A16UserProfilePage extends JFrame {
    private A3User user;

    public A16UserProfilePage(A3User user) {
        this.user = user;

        setTitle("User Profile");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        add(new JLabel("Welcome, " + user.getUsername(), SwingConstants.CENTER));
        add(new JLabel("Email: " + user.getEmail(), SwingConstants.CENTER));

        JButton viewBookingsButton = new JButton("View Bookings");
        viewBookingsButton.addActionListener(e -> {
            // Implement booking history display
            JOptionPane.showMessageDialog(A16UserProfilePage.this, "Booking history feature to be implemented.");
        });
        add(viewBookingsButton);
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

public class A16UserProfilePage extends JFrame {
    private A3User user;
    private BufferedImage backgroundImage;

    public A16UserProfilePage(A3User user) {
        this.user = user;

        // Load background image
        try {
            backgroundImage = ImageIO.read(new File("C:/Users/aaral/Downloads/f8.jpg")); // Update with your image path
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("User Profile");
        setSize(300, 300);
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

        // Add welcome message
        JLabel welcomeLabel = new JLabel("Welcome, " + user.getUsername(), SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Change font style
        gbc.gridy = 0;
        panel.add(welcomeLabel, gbc);

        // Add email label
        JLabel emailLabel = new JLabel("Email: " + user.getEmail(), SwingConstants.CENTER);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Change font style
        gbc.gridy = 1;
        panel.add(emailLabel, gbc);

        // Create "Search Flights" button
        JButton searchFlightsButton = new JButton("Search Flights");
        searchFlightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Navigate to Flight Search Page
                new A11FlightSearchPage(user).setVisible(true);
                dispose(); // Close User Profile Page
            }
        });
        gbc.gridy = 2;
        panel.add(searchFlightsButton, gbc);

        // Set content pane
        setContentPane(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            A3User user = new A3User(); // Dummy user for testing
            new A16UserProfilePage(user).setVisible(true);
        });
    }
}
