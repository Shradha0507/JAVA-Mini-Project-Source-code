
import javax.swing.*;
import java.awt.*;

public class A17AdminDashboard extends JFrame {
    public A17AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1));

        JButton manageFlightsButton = new JButton("Manage Flights");
        manageFlightsButton.addActionListener(e -> {
            // Implement flight management
            JOptionPane.showMessageDialog(A17AdminDashboard.this, "Flight management feature to be implemented.");
        });
        add(manageFlightsButton);

        JButton manageUsersButton = new JButton("Manage Users");
        manageUsersButton.addActionListener(e -> {
            // Implement user management
            JOptionPane.showMessageDialog(A17AdminDashboard.this, "User management feature to be implemented.");
        });
        add(manageUsersButton);
    }
}
